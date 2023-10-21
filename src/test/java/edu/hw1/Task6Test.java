package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Функция Капрекара для 3524")
    void countK1() {
        // given
        int number = 3524;

        // when
        int k = Task6.runTask6(number);

        // then
        assertThat(k)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Функция Капрекара для 6621")
    void countK2() {
        // given
        int number = 6621;

        // when
        int k = Task6.runTask6(number);

        // then
        assertThat(k)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("Функция Капрекара для 6554")
    void countK3() {
        // given
        int number = 6554;

        // when
        int k = Task6.runTask6(number);

        // then
        assertThat(k)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Функция Капрекара для 1234")
    void countK4() {
        // given
        int number = 1234;

        // when
        int k = Task6.runTask6(number);

        // then
        assertThat(k)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Функция Капрекара для 1000")
    void countK5() {
        // given
        int number = 1000;

        // when
        int k = Task6.runTask6(number);

        // then
        assertThat(k)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Функция Капрекара для 11111")
    void countK6() {
        // given
        int number = 11111;

        // when
        int k = Task6.runTask6(number);

        // then
        assertThat(k)
            .isEqualTo(0);
    }
}
