package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();
    private final static String SIMULATION_NUM_ERR = "Number of simulations is 0.";
    private final static String THREAD_NUM_ERR = "Number of threads is 0.";
    private final static String INVALID_INPUT = "Invalid input.";
    private final static double MULTIPLIER = 4.0;
    private final static int PERCENT = 100;
    private final static String NUM_FORMAT = "%.2f";
    private final static int PARAMS_NUM = 3;

    private Task4() {

    }

    private static long getCircleCount(int numSimulations) {
        long circleCount = 0;

        for (int i = 0; i < numSimulations; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-1, 1);
            double y = ThreadLocalRandom.current().nextDouble(-1, 1);

            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }
        return circleCount;
    }

    private static double calculatePiSingleThread(int numSimulations) {
        if (numSimulations == 0) {
            LOGGER.error(SIMULATION_NUM_ERR);
            return 0;
        }
        return MULTIPLIER * getCircleCount(numSimulations) / numSimulations;
    }

    private static double calculatePiMultiThread(int numSimulations, int numThreads) throws InterruptedException {
        if (numSimulations == 0) {
            LOGGER.error(SIMULATION_NUM_ERR);
            return 0;
        }
        if (numThreads == 0) {
            LOGGER.error(THREAD_NUM_ERR);
            return 0;
        }
        AtomicLong circleCount = new AtomicLong(0);

        Thread[] threads = new Thread[numThreads];
        int simulationsPerThread = numSimulations / numThreads;

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                long localCircleCount = getCircleCount(simulationsPerThread);
                circleCount.addAndGet(localCircleCount);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return MULTIPLIER * circleCount.get() / numSimulations;
    }

    public static double[] analyze(int[] numSimulationsArray, int[] numThreadsArray) {
        double[] result = new double[PARAMS_NUM];
        if (numSimulationsArray == null || numThreadsArray == null) {
            LOGGER.error(INVALID_INPUT);
            return new double[] {};
        }
        if (numSimulationsArray.length == 0 || numThreadsArray.length == 0) {
            LOGGER.error(INVALID_INPUT);
            return new double[] {};
        }
        List<Long> singleThreadTime = new ArrayList<>();
        List<Double> singleThreadPi = new ArrayList<>();

        List<Long> multiThreadTime = new ArrayList<>();
        List<Double> multiThreadPi = new ArrayList<>();

        for (Integer numSimulations : numSimulationsArray) {
            long startTime = System.currentTimeMillis();
            singleThreadPi.add(calculatePiSingleThread(numSimulations));
            long endTime = System.currentTimeMillis();
            singleThreadTime.add(endTime - startTime);

            for (Integer numThreads : numThreadsArray) {
                startTime = System.currentTimeMillis();
                try {
                    multiThreadPi.add(calculatePiMultiThread(numSimulations, numThreads));
                    endTime = System.currentTimeMillis();
                    multiThreadTime.add(endTime - startTime);
                } catch (InterruptedException e) {
                    LOGGER.error(e);
                }
            }
        }
        double singleThreadAveragePi = singleThreadPi.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double multiThreadAveragePi = multiThreadPi.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        double relativeErrorSingleThread = (Math.abs(singleThreadAveragePi - Math.PI) / Math.PI) * PERCENT;
        result[0] = relativeErrorSingleThread;
        double relativeErrorMultiThread = (Math.abs(multiThreadAveragePi - Math.PI) / Math.PI) * PERCENT;
        result[1] = relativeErrorMultiThread;

        double singleThreadAverageTime = singleThreadTime.stream().mapToDouble(Long::doubleValue).average().orElse(0.0);
        double multiThreadAverageTime = multiThreadTime.stream().mapToDouble(Long::doubleValue).average().orElse(0.0);

        double boost = 0;
        if (multiThreadAverageTime != 0) {
            boost = singleThreadAverageTime / multiThreadAverageTime;
        }
        result[2] = boost;
        return result;
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static String printInfo(double[] data) {
        if (data == null || data.length < PARAMS_NUM) {
            LOGGER.error(INVALID_INPUT);
            return "";
        }

        return "Relative single thread error: " + String.format(NUM_FORMAT, data[0])
            + "% \n"
            + "Relative multi threads error: " + String.format(NUM_FORMAT, data[1])
            + "% \n"
            + "Boost: " + String.format(NUM_FORMAT, data[2])
            + " \n";
    }

    public static void runTask4(int[] numSimulationsArray, int[] numThreadsArray) {
        printInfo(analyze(numSimulationsArray, numThreadsArray));
    }
}

