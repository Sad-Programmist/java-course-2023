package edu.hw1;

public class Task4 {

    private Task4() {
    }

    private static String fixString(String string) {
        if (string != null) {
            char[] arrString = string.toCharArray();
            for (int numberIndex = 0; numberIndex < arrString.length - 1; numberIndex = numberIndex + 2) {
                char temp = arrString[numberIndex];
                arrString[numberIndex] = arrString[numberIndex + 1];
                arrString[numberIndex + 1] = temp;
            }
            return String.valueOf(arrString);
        }
        return null;
    }

    public static String runTask4(String string) {
        return fixString(string);
    }
}
