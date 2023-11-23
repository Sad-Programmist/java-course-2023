package edu.hw7.task1;

import org.apache.logging.log4j.LogManager;

public class Task1 {

    private Task1() {
    }

    private static int createConcurrentCounter(int threadNumber, int operationNumber) {
        if (threadNumber < 0) {
            return 0;
        }

        Counter counter = new Counter();
        Thread[] threads = new Thread[threadNumber];
        for (int threadIndex = 0; threadIndex < threadNumber; threadIndex++) {
            threads[threadIndex] = new IncrementThread(counter, operationNumber);
            threads[threadIndex].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LogManager.getLogger().error("Error in joining threads");
            }
        }

        return counter.getCounter();
    }

    public static int runTask1(int threadNumber, int operationNumber) {
        return createConcurrentCounter(threadNumber, operationNumber);
    }
}
