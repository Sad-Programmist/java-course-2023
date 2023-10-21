package edu.hw1;

public class Task2 {

    private Task2() {
    }

    private static int countDigits(int number) {
        int tempNumber = number;
        if (tempNumber == 0) {
            return 1;
        }

        if (tempNumber < 0) {
            tempNumber *= -1;
        }

        int numberOfDigits = 0;
        while (tempNumber > 0) {
            tempNumber = tempNumber / Constants.BASIS_OF_NUMBER_SYSTEM_10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    public static int runTask2(int number) {
        return countDigits(number);
    }
}
