package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Рассчет количества цифр в числе 4666")
    void countDigits1() {
        // given
        int number = 4666;

        // when
        int numberOfDigits = Task2.runTask2(number);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Рассчет количества цифр в числе 544")
    void countDigits2() {
        // given
        int number = 544;

        // when
        int numberOfDigits = Task2.runTask2(number);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Рассчет количества цифр в числе 0")
    void countDigits3() {
        // given
        int number = 0;

        // when
        int numberOfDigits = Task2.runTask2(number);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Рассчет количества цифр в числе -100")
    void countDigits4() {
        // given
        int number = -100;

        // when
        int numberOfDigits = Task2.runTask2(number);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(3);
    }
}
