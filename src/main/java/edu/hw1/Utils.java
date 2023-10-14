package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    private Utils() {
    }

    /**
     * Counts and returns the number of digits in a given number.
     *
     * @param number the number for which to count the digits
     * @param basis the basis of number system
     * @return the number of digits in the input number
     */
    public static int countDigits(int number, int basis) {
        int tempNumber = number;
        if (tempNumber == 0) {
            return 1;
        }

        if (tempNumber < 0) {
            tempNumber *= -1;
        }

        int numberOfDigits = 0;
        while (tempNumber > 0) {
            tempNumber = tempNumber / basis;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    /**
     * Converts an array of decimal system digits into an integer decimal system number.
     * <p>
     * This method takes an array of decimal system digits and converts them
     * into a single integer decimal system number.
     * It iterates through the array and appends each digit to the result after multiplying the result
     * by 10 (the base of the decimal system).
     *
     * @param array An array of digits to be converted to an integer.
     * @return The integer number representing the given array of digits. Returns 0 if any digit is not in the range
     *     [0, 9].
     */
    public static int arrayToNumber(int[] array) {
        int result = 0;
        for (int digit : array) {
            if (digit > Constants.MAX_DIGIT || digit < Constants.MIN_DIGIT) {
                return 0;
            }
            result = result * Constants.BASIS_OF_NUMBER_SYSTEM_10 + digit;
        }
        return result;
    }

    /**
     * Converts an integer number into an array of individual digits.
     *
     * @param number the integer number to be converted
     * @param basis the basis of number system
     * @return an array containing the individual digits of the number
     */
    public static int[] numberToArray(int number, int basis) {
        int[] result = new int[countDigits(number, basis)];
        int tempNumber = number;
        for (int numberIndex = result.length - 1; numberIndex >= 0; numberIndex--) {
            result[numberIndex] = tempNumber % basis;
            tempNumber = tempNumber / basis;
        }
        return result;
    }

    /**
     * Inverts the order of elements in an integer array.
     *
     * @param array the integer array to be inverted
     * @return a new array with the elements in reverse order
     */
    public static int[] invertArray(int[] array) {
        if (array == null) {
            return null;
        }
        return IntStream.range(0, array.length)
            .mapToObj(i -> array[array.length - 1 - i])
            .mapToInt(Integer::intValue)
            .toArray();
    }

    /**
     * Checks if an integer array is a palindrome.
     *
     * @param array the integer array to be checked for palindrome property
     * @return true if the array is a palindrome, false otherwise
     */
    public static boolean isArrayPalindrome(int[] array) {
        if (array == null) {
            return false;
        }
        return Arrays.equals(array, invertArray(array));
    }

    /**
     * Generates a new array by combining adjacent elements in pairs.
     * If the input array has an odd length, the last element remains unchanged in the new array.
     *
     * @param array the input integer array
     * @return a new array with combined adjacent elements
     */
    public static int[] countChild(int[] array) {
        if (array == null) {
            return null;
        }
        int arrayLength = array.length;
        List<Integer> child = new ArrayList<>();
        for (int numberIndex = 0; numberIndex < arrayLength; numberIndex += 2) {
            if (numberIndex + 1 < arrayLength) {
                int newNumber = array[numberIndex] + array[numberIndex + 1];
                if (newNumber >= Constants.BASIS_OF_NUMBER_SYSTEM_10) {
                    child.add(1);
                }
                child.add(newNumber % Constants.BASIS_OF_NUMBER_SYSTEM_10);
            } else {
                child.add(array[numberIndex]);
            }
        }
        return child.stream().mapToInt(Integer::intValue).toArray();
    }
}
