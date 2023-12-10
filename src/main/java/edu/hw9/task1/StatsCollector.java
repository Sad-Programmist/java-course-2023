package edu.hw9.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;

public class StatsCollector {

    private final ConcurrentHashMap<String, List<Double>> dataMap;
    private final ExecutorService executorService;

    public StatsCollector(int threadPoolSize) {
        this.dataMap = new ConcurrentHashMap<>();
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void push(String metricName, double[] data) {
        for (double value : data) {
            dataMap.computeIfAbsent(metricName, k -> Collections.synchronizedList(new ArrayList<>()))
                .add(value);
        }
    }

    public List<MetricStats> stats() {
        List<MetricStats> result = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (String metricName : dataMap.keySet()) {
            List<Double> values = new ArrayList<>(dataMap.get(metricName));

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                double sum = values.stream().mapToDouble(Double::doubleValue).sum();
                double average = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                double max = Collections.max(values);
                double min = Collections.min(values);

                MetricStats metricStats = new MetricStats(metricName, sum, average, max, min);
                synchronized (dataMap) {
                    result.add(metricStats);
                }
            }, executorService);

            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            LogManager.getLogger().error(e.getMessage());
        }

        executorService.shutdown();

        return result;
    }

    public ConcurrentHashMap<String, List<Double>> getDataMap() {
        return dataMap;
    }
}
