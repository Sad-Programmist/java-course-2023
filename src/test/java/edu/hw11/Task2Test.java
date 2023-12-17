package edu.hw11;

import edu.hw11.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Проверка метода для 2 и 3")
    void task2Test1() throws IllegalAccessException, InstantiationException {
        //given
        int a = 2;
        int b = 3;

        // when
        int result = Task2.runTask2(a, b);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Проверка метода для 2 и 0")
    void task2Test2() throws IllegalAccessException, InstantiationException {
        //given
        int a = 2;
        int b = 0;

        // when
        int result = Task2.runTask2(a, b);

        // then
        assertThat(result).isEqualTo(0);
    }
}
