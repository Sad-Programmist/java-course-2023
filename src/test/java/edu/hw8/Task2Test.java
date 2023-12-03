package edu.hw8;

import edu.hw8.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Вычисление первых 5 чисел Фибоначчи")
    void calculateFibonacci1() {
        // given
        int start = 0;
        int end = 4;
        int numThreads = 2;

        // when
        List<Integer> result = Task2.runTask2(start, end, numThreads);

        // then
        assertThat(result)
            .isEqualTo(List.of(0, 1, 1, 2, 3));
    }

    @Test
    @DisplayName("Вычисление чисел Фибоначчи с -10 по 10")
    void calculateFibonacci2() {
        // given
        int start = -10;
        int end = 10;
        int numThreads = 2;

        // when
        List<Integer> result = Task2.runTask2(start, end, numThreads);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Вычисление чисел Фибоначчи с -20 по -10")
    void calculateFibonacci3() {
        // given
        int start = -20;
        int end = -10;
        int numThreads = 2;

        // when
        List<Integer> result = Task2.runTask2(start, end, numThreads);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Вычисление чисел Фибоначчи с 20 по -10")
    void calculateFibonacci4() {
        // given
        int start = 20;
        int end = -10;
        int numThreads = 2;

        // when
        List<Integer> result = Task2.runTask2(start, end, numThreads);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }
}
