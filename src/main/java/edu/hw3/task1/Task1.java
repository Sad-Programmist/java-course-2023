package edu.hw3.task1;

public class Task1 {
    private final static String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final static String UPPER_CASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static int ALPHABET_LENGTH = 'z' - 'a' + 1;

    private Task1() {
    }

    private static String atbash(String startString) {
        if (startString == null) {
            return "";
        }

        char[] charArray = startString.toCharArray();
        for (int charIndex = 0; charIndex < charArray.length; charIndex++) {
            int lowerIndex = LOWER_CASE_ALPHABET.indexOf(charArray[charIndex]);
            if (lowerIndex >= 0) {
                charArray[charIndex] = LOWER_CASE_ALPHABET.charAt(ALPHABET_LENGTH - lowerIndex - 1);
            } else {
                int upperIndex = UPPER_CASE_ALPHABET.indexOf(charArray[charIndex]);
                if (upperIndex >= 0) {
                    charArray[charIndex] = UPPER_CASE_ALPHABET.charAt(ALPHABET_LENGTH - upperIndex - 1);
                }
            }
        }
        return new String(charArray);
    }

    public static String runTask1(String startString) {
        return atbash(startString);
    }
}
