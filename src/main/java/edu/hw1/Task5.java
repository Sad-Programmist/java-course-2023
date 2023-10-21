package edu.hw1;

public class Task5 {

    private Task5() {
    }

    private static boolean isPalindromeDescendant(int number) {
        int[] numberArray = Utils.numberToArray(number, Constants.BASIS_OF_NUMBER_SYSTEM_10);
        while (numberArray.length >= 2) {
            if (Utils.isArrayPalindrome(numberArray)) {
                return true;
            }
            numberArray = Utils.countChild(numberArray);
        }
        return false;
    }

    public static boolean runTask5(int number) {
        return isPalindromeDescendant(number);
    }
}
