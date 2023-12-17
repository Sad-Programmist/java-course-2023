package edu.hw10;

import edu.hw10.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task2Test {

    @Test
    @DisplayName("Вычисление числа Фибоначчи под номером 6")
    void fibCalculatorTest1() {
        //given
        int n = 6;

        // when
        long result = Task2.runTask2(n);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("Вычисление числа Фибоначчи под номером -100")
    void fibCalculatorTest2() {
        //given
        int n = -100;

        // when
        long result = Task2.runTask2(n);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Вычисление числа Фибоначчи под номером 6")
    void fibCalculatorTest3() {
        //given
        int n = 6;

        // when
        Task2.runTask2(n);

        // then
        assertThat(new File("tempCache/fib[6].ser").exists()).isTrue();
    }
}
