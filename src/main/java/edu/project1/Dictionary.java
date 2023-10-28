package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Dictionary {
    private Dictionary() {
    }

    private final static String[] DICTIONARY = new String[] {"cat", "dog", "animal"};

    @NotNull
    public static String randomWord() {
        Random random = new Random();
        int index = random.nextInt(DICTIONARY.length);
        return DICTIONARY[index];
    }
}
