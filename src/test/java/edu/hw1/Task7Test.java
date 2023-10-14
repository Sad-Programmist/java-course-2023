package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Циклический сдвиг влево числа 16 на 1 бит")
    void rotateLeft1() {
        // given
        int number = 16;
        int shift = 1;

        // when
        int newNumber = Task7.runTask7Left(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Циклический сдвиг влево числа 17 на 2 бита")
    void rotateLeft2() {
        // given
        int number = 17;
        int shift = 2;

        // when
        int newNumber = Task7.runTask7Left(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Циклический сдвиг влево числа 0 на 2 бита")
    void rotateLeft3() {
        // given
        int number = 0;
        int shift = 2;

        // when
        int newNumber = Task7.runTask7Left(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Циклический сдвиг вправо числа 8 на 1 бит")
    void rotateRight1() {
        // given
        int number = 8;
        int shift = 1;

        // when
        int newNumber = Task7.runTask7Right(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Циклический сдвиг вправо числа 8 на 4 бита")
    void rotateRight2() {
        // given
        int number = 8;
        int shift = 4;

        // when
        int newNumber = Task7.runTask7Right(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(8);
    }

    @Test
    @DisplayName("Циклический сдвиг вправо числа 0 на 3 бита")
    void rotateRight3() {
        // given
        int number = 0;
        int shift = 3;

        // when
        int newNumber = Task7.runTask7Right(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Циклический сдвиг вправо числа -2 на 1 бит")
    void rotateRight4() {
        // given
        int number = -2;
        int shift = 1;

        // when
        int newNumber = Task7.runTask7Right(number, shift);

        // then
        assertThat(newNumber)
            .isEqualTo(-1);
    }
}
