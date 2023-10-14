package edu.hw1;

public class Task7 {

    private Task7() {
    }

    private static int rotateLeft(int n, int shift) {
        int number = n;
        int shiftCount = shift;
        int maxNumberPlace = Utils.countDigits(n, Constants.BASIS_OF_NUMBER_SYSTEM_2) - 1;
        int pow = (int) Math.pow(Constants.BASIS_OF_NUMBER_SYSTEM_2, maxNumberPlace);
        while (shiftCount > 0) {
            int firstDigit = number / pow;
            int left = number % pow;
            number = left * Constants.BASIS_OF_NUMBER_SYSTEM_2 + firstDigit;
            shiftCount--;
        }
        return number;
    }

    private static int rotateRight(int n, int shift) {
        int number = n;
        int shiftCount = shift;
        int maxNumberPlace = Utils.countDigits(n, Constants.BASIS_OF_NUMBER_SYSTEM_2) - 1;
        while (shiftCount > 0) {
            int firstDigit = number % Constants.BASIS_OF_NUMBER_SYSTEM_2;
            int left = number / Constants.BASIS_OF_NUMBER_SYSTEM_2;
            number = firstDigit * (int) Math.pow(Constants.BASIS_OF_NUMBER_SYSTEM_2, maxNumberPlace) + left;
            shiftCount--;
        }
        return number;
    }

    public static int runTask7Left(int n, int shift) {
        return rotateLeft(n, shift);
    }

    public static int runTask7Right(int n, int shift) {
        return rotateRight(n, shift);
    }
}
