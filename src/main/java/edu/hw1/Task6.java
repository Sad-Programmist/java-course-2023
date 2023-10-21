package edu.hw1;

import java.util.Arrays;

public class Task6 {

    private Task6() {
    }

    private static int countDifference(int[] digits) {
        Arrays.sort(digits);
        int[] bigger = Utils.invertArray(digits);

        return Utils.arrayToNumber(bigger) - Utils.arrayToNumber(digits);
    }

    private static int countK(int[] digits, int k) {
        int tempK = k;
        if (Arrays.equals(digits, Utils.numberToArray(Constants.KAPREKAR_CONST, Constants.BASIS_OF_NUMBER_SYSTEM_10))) {
            return tempK;
        } else {
            int difference = countDifference(digits);
            tempK++;
            tempK = countK(Utils.numberToArray(difference, Constants.BASIS_OF_NUMBER_SYSTEM_10), tempK);
        }
        return tempK;
    }

    private static int countK(int number) {
        if (number > Constants.MIN_FOUR_DIGIT_NUMBER && number < Constants.MIN_FIVE_DIGIT_NUMBER) {
            int difference = countDifference(Utils.numberToArray(number, Constants.BASIS_OF_NUMBER_SYSTEM_10));
            int k = 1;
            return countK(Utils.numberToArray(difference, Constants.BASIS_OF_NUMBER_SYSTEM_10), k);
        }
        return 0;
    }

    public static int runTask6(int number) {
        return countK(number);
    }
}
