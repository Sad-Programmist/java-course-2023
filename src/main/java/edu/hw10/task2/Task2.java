package edu.hw10.task2;

public class Task2 {

    private Task2() {
    }

    public static long runTask2(int n) {
        if (n < 0) {
            return 0;
        }

        FibCalculator fibCalculator = new SimpleFibCalculator();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class, "tempCache");

        return proxy.fib(n);
    }
}
