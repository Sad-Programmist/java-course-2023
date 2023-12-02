package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Рассчет факториала числа 5")
    void factorialParallel1() {
        //given
        int number = 5;

        //when
        long result = Task2.runTask2(number);

        //then
        assertThat(result).isEqualTo(120);
    }

    @Test
    @DisplayName("Рассчет факториала числа 10")
    void factorialParallel2() {
        //given
        int number = 10;

        //when
        long result = Task2.runTask2(number);

        //then
        assertThat(result).isEqualTo(3628800);
    }

    @Test
    @DisplayName("Рассчет факториала числа 0")
    void factorialParallel3() {
        //given
        int number = 0;

        //when
        long result = Task2.runTask2(number);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Рассчет факториала числа -100")
    void factorialParallel4() {
        //given
        int number = -100;

        //when
        long result = Task2.runTask2(number);

        //then
        assertThat(result).isEqualTo(0);
    }
}
