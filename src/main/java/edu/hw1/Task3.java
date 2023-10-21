package edu.hw1;

import java.util.Arrays;

public class Task3 {

    private Task3() {
    }

    private static boolean isNestable(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return false;
        }
        int min1 = Arrays.stream(array1)
            .min()
            .getAsInt();
        int min2 = Arrays.stream(array2)
            .min()
            .getAsInt();
        int max1 = Arrays.stream(array1)
            .max()
            .getAsInt();
        int max2 = Arrays.stream(array2)
            .max()
            .getAsInt();

        if (min1 > min2 && max1 < max2) {
            return true;
        }
        return false;
    }

    public static boolean runTask3(int[] array1, int[] array2) {
        return isNestable(array1, array2);
    }
}
