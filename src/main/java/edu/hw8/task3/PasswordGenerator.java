package edu.hw8.task3;

import java.util.Iterator;

public class PasswordGenerator implements Iterator<String> {
    private static final int MIN_DIGIT = '0';
    private static final int MAX_DIGIT = '9';
    private static final int MIN_LETTER = 'a';
    private static final int MAX_LETTER = 'z';
    private char[] currentPassword;

    public PasswordGenerator() {
        currentPassword = new char[] {MIN_DIGIT, MIN_DIGIT, MIN_DIGIT};
    }

    @Override
    public boolean hasNext() {
        return currentPassword[2] < MAX_LETTER;
    }

    @Override
    public String next() {
        String password = new String(currentPassword);

        if (currentPassword[0] < MAX_LETTER) {
            currentPassword[0]++;
        } else {
            currentPassword[0] = MIN_DIGIT;
            if (currentPassword[1] < MAX_LETTER) {
                currentPassword[1]++;
            } else {
                currentPassword[1] = MIN_DIGIT;
                currentPassword[2]++;
            }
        }

        return password;
    }
}
