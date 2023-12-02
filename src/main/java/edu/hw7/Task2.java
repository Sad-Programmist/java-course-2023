package edu.hw7;

import java.util.stream.LongStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task2() {
    }

    private static long factorialParallel(long n) {
        if (n < 0) {
            LOGGER.error("Number must be non-negative.");
            return 0;
        }
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, (a, b) -> a * b);
    }

    public static long runTask2(long n) {
        return factorialParallel(n);
    }
}
