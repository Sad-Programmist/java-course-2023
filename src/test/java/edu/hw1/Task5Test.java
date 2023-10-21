package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Являются ли число 11211230 или его потомки палиндромами")
    void isPalindromeDescendant1() {
        // given
        int number = 11211230;

        // when
        boolean isPalindromeDescendant = Task5.runTask5(number);

        // then
        assertThat(isPalindromeDescendant)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Являются ли число 13001120 или его потомки палиндромами")
    void isPalindromeDescendant2() {
        // given
        int number = 13001120;

        // when
        boolean isPalindromeDescendant = Task5.runTask5(number);

        // then
        assertThat(isPalindromeDescendant)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Являются ли число 23336014 или его потомки палиндромами")
    void isPalindromeDescendant3() {
        // given
        int number = 23336014;

        // when
        boolean isPalindromeDescendant = Task5.runTask5(number);

        // then
        assertThat(isPalindromeDescendant)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Являются ли число 11 или его потомки палиндромами")
    void isPalindromeDescendant4() {
        // given
        int number = 11;

        // when
        boolean isPalindromeDescendant = Task5.runTask5(number);

        // then
        assertThat(isPalindromeDescendant)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Являются ли число 11211231 или его потомки палиндромами")
    void isPalindromeDescendant5() {
        // given
        int number = 11211231;

        // when
        boolean isPalindromeDescendant = Task5.runTask5(number);

        // then
        assertThat(isPalindromeDescendant)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Являются ли число 1 или его потомки палиндромами")
    void isPalindromeDescendant6() {
        // given
        int number = 11211231;

        // when
        boolean isPalindromeDescendant = Task5.runTask5(number);

        // then
        assertThat(isPalindromeDescendant)
            .isEqualTo(false);
    }
}
