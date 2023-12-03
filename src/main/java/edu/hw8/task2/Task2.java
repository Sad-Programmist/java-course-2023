package edu.hw8.task2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task2 {

    private Task2() {
    }

    private static List<Integer> calculateFibonacci(int start, int end, int numThreads) {
        if (start < 0 || end <= 0 || start >= end) {
            return Collections.emptyList();
        }

        List<Integer> result = new CopyOnWriteArrayList<>();
        ThreadPool threadPool = FixedThreadPool.create(numThreads);
        threadPool.start();

        for (int i = start; i <= end; i++) {
            int finalInd = i;
            threadPool.execute(() -> result.add(fibonacci(finalInd)));
        }

        while (result.size() != end - start + 1) {

        }
        try {
            threadPool.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static List<Integer> runTask2(int start, int end, int numThreads) {
        return calculateFibonacci(start, end, numThreads);
    }
}
