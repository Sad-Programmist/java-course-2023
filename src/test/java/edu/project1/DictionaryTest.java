package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DictionaryTest {

    @Test
    @DisplayName("Проверка получения слова, которое нет в словаре")
    void getNotDictionaryWord() {
        // when
        String word = Dictionary.randomWord();

        // then
        assertNotEquals("wrong", word);
    }
}
