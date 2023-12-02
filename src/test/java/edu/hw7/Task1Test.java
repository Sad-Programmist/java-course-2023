package edu.hw7;

import edu.hw7.task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Увеличение счетчика 50 потоками на 50 значений каждым")
    void createConcurrentCounter1() {
        // given
        int threadNumber = 50;
        int operationNumber = 50;

        // when
        int result = Task1.runTask1(threadNumber, operationNumber);

        // then
        assertThat(result)
            .isEqualTo(threadNumber * operationNumber);
    }

    @Test
    @DisplayName("Увеличение счетчика 1 потоком на 100 значений каждым")
    void createConcurrentCounter2() {
        // given
        int threadNumber = 1;
        int operationNumber = 100;

        // when
        int result = Task1.runTask1(threadNumber, operationNumber);

        // then
        assertThat(result)
            .isEqualTo(threadNumber * operationNumber);
    }

    @Test
    @DisplayName("Увеличение счетчика 50 потоками на 1 значение каждым")
    void createConcurrentCounter3() {
        // given
        int threadNumber = 50;
        int operationNumber = 1;

        // when
        int result = Task1.runTask1(threadNumber, operationNumber);

        // then
        assertThat(result)
            .isEqualTo(threadNumber * operationNumber);
    }

    @Test
    @DisplayName("Увеличение счетчика -50 потоками на 10 значение каждым")
    void createConcurrentCounter4() {
        // given
        int threadNumber = -50;
        int operationNumber = 10;

        // when
        int result = Task1.runTask1(threadNumber, operationNumber);

        // then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Увеличение счетчика 50 потоками на -10 значение каждым")
    void createConcurrentCounter5() {
        // given
        int threadNumber = 50;
        int operationNumber = -10;

        // when
        int result = Task1.runTask1(threadNumber, operationNumber);

        // then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Увеличение счетчика 0 потоками на 10 значение каждым")
    void createConcurrentCounter6() {
        // given
        int threadNumber = 0;
        int operationNumber = -10;

        // when
        int result = Task1.runTask1(threadNumber, operationNumber);

        // then
        assertThat(result)
            .isEqualTo(0);
    }
}
