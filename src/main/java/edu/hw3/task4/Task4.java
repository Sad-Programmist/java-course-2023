package edu.hw3.task4;

public class Task4 {

    private Task4() {
    }

    @SuppressWarnings("MagicNumber")
    private static String convertToRoman(int arabicNumber) {
        int tempArabicNumber = arabicNumber;
        if (arabicNumber <= 0 || arabicNumber > 3999) {
            return "Number must be in the range from 1 to 3999";
        }

        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();

        int i = 0;
        while (tempArabicNumber > 0) {
            if (tempArabicNumber >= arabicValues[i]) {
                roman.append(romanSymbols[i]);
                tempArabicNumber -= arabicValues[i];
            } else {
                i++;
            }
        }

        return roman.toString();
    }

    public static String runTask4(int arabicNumber) {
        return convertToRoman(arabicNumber);
    }
}
