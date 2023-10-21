package edu.hw1;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Task3 {

    private Task3() {
    }

    private static boolean isNestable(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return false;
        }
        IntStream stream1 = IntStream.of(array1);
        IntSummaryStatistics summaryData1 = stream1.summaryStatistics();
        int min1 = summaryData1.getMin();
        int max1 = summaryData1.getMax();

        IntStream stream2 = IntStream.of(array2);
        IntSummaryStatistics summaryData2 = stream2.summaryStatistics();
        int min2 = summaryData2.getMin();
        int max2 = summaryData2.getMax();

        return min1 > min2 && max1 < max2;
    }

    public static boolean runTask3(int[] array1, int[] array2) {
        return isNestable(array1, array2);
    }
}
