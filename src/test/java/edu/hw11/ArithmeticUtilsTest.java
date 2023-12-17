package edu.hw11;

import edu.hw11.task2.ArithmeticUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArithmeticUtilsTest {

    @Test
    @DisplayName("Вычисление суммы для 2 и 3")
    void arithmeticUtilsTest1() {
        //given
        int a = 2;
        int b = 3;
        ArithmeticUtils arithmeticUtils = new ArithmeticUtils();

        // when
        int result = arithmeticUtils.sum(a, b);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Вычисление суммы для 2 и 0")
    void arithmeticUtilsTest2() {
        //given
        int a = 2;
        int b = 0;
        ArithmeticUtils arithmeticUtils = new ArithmeticUtils();

        // when
        int result = arithmeticUtils.sum(a, b);

        // then
        assertThat(result).isEqualTo(2);
    }
}
