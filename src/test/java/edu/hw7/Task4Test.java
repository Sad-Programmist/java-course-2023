package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Точность числа Пи в 10000000 экспериментах и в 1 поток")
    void calculatePi1() {
        //given
        int[] numSimulationsArray = {10000000};
        int[] numThreadsArray = {100};

        //when
        double[] result = Task4.analyze(numSimulationsArray, numThreadsArray);

        //then
        assertThat(result[0] < 0.05).isTrue();
    }

    @Test
    @DisplayName("Точность числа Пи в 10000000 экспериментах и в 100 потоков")
    void calculatePi2() {
        //given
        int[] numSimulationsArray = {10000000};
        int[] numThreadsArray = {100};

        //when
        double[] result = Task4.analyze(numSimulationsArray, numThreadsArray);

        //then
        assertThat(result[1] < 0.05).isTrue();
    }

    @Test
    @DisplayName("Рассчет числа Пи, когда первый параметр null")
    void calculatePi3() {
        //given
        int[] numThreadsArray = {1, 2, 4};

        //when
        double[] result = Task4.analyze(null, numThreadsArray);

        //then
        assertThat(result).isEqualTo(new double[] {});
    }

    @Test
    @DisplayName("Рассчет числа Пи, когда второй параметр null")
    void calculatePi4() {
        //given
        int[] numSimulationsArray = {1000000, 10000000};

        //when
        double[] result = Task4.analyze(numSimulationsArray, null);

        //then
        assertThat(result).isEqualTo(new double[] {});
    }

    @Test
    @DisplayName("Рассчет числа Пи, когда первый параметр пустой массив")
    void calculatePi5() {
        //given
        int[] numSimulationsArray = {};
        int[] numThreadsArray = {1, 2, 4};

        //when
        double[] result = Task4.analyze(numSimulationsArray, numThreadsArray);

        //then
        assertThat(result).isEqualTo(new double[] {});
    }

    @Test
    @DisplayName("Рассчет числа Пи, когда второй параметр пустой массив")
    void calculatePi6() {
        //given
        int[] numSimulationsArray = {1000000, 10000000};
        int[] numThreadsArray = {};

        //when
        double[] result = Task4.analyze(numSimulationsArray, numThreadsArray);

        //then
        assertThat(result).isEqualTo(new double[] {});
    }

    @Test
    @DisplayName("Вывод информации для 0.0, 0.0, 0.0")
    void calculatePi7() {
        //given
        double[] data = {0.0, 0.0, 0.0};

        //when
        String result = Task4.printInfo(data);

        //then
        assertThat(result).isEqualTo("""
            Relative single thread error: 0.00%\s
            Relative multi threads error: 0.00%\s
            Boost: 0.00\s
            """);
    }

    @Test
    @DisplayName("Вывод информации для пустого массива")
    void calculatePi8() {
        //given
        double[] data = {};

        //when
        String result = Task4.printInfo(data);

        //then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Вывод информации для массива равного null")
    void calculatePi9() {
        //when
        String result = Task4.printInfo(null);

        //then
        assertThat(result).isEqualTo("");
    }
}
