package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilsTest {

    @Test
    @DisplayName("Рассчет количества цифр в числе 544")
    void countDigits1() {
        // given
        int number = 544;
        int basis = Constants.BASIS_OF_NUMBER_SYSTEM_10;

        // when
        int numberOfDigits = Utils.countDigits(number, basis);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Рассчет количества цифр в числе 0")
    void countDigits2() {
        // given
        int number = 0;
        int basis = Constants.BASIS_OF_NUMBER_SYSTEM_10;

        // when
        int numberOfDigits = Utils.countDigits(number, basis);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Рассчет количества цифр в числе -100")
    void countDigits3() {
        // given
        int number = -100;
        int basis = Constants.BASIS_OF_NUMBER_SYSTEM_10;

        // when
        int numberOfDigits = Utils.countDigits(number, basis);

        // then
        assertThat(numberOfDigits)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Конвертация массива цифр [1, 2, 3, 4, 5] в одно число")
    void arrayToNumber1() {
        // given
        int[] array = {1, 2, 3, 4, 5};

        // when
        int number = Utils.arrayToNumber(array);

        // then
        assertThat(number)
            .isEqualTo(12345);
    }

    @Test
    @DisplayName("Конвертация массива цифр [11, 1, 0] в одно число")
    void arrayToNumber2() {
        // given
        int[] array = {11, 1, 0};

        // when
        int number = Utils.arrayToNumber(array);

        // then
        assertThat(number)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Конвертация массива цифр [] в одно число")
    void arrayToNumber3() {
        // given
        int[] array = {};

        // when
        int number = Utils.arrayToNumber(array);

        // then
        assertThat(number)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Конвертация числа в массив цифр для 1234")
    void numberToArray1() {
        // given
        int number = 1234;
        int basis = Constants.BASIS_OF_NUMBER_SYSTEM_10;

        // when
        int[] array = Utils.numberToArray(number, basis);

        // then
        assertThat(array)
            .isEqualTo(new int[] {1, 2, 3, 4});
    }

    @Test
    @DisplayName("Конвертация числа в массив цифр для 0")
    void numberToArray2() {
        // given
        int number = 0;
        int basis = Constants.BASIS_OF_NUMBER_SYSTEM_10;

        // when
        int[] array = Utils.numberToArray(number, basis);

        // then
        assertThat(array)
            .isEqualTo(new int[] {0});
    }

    @Test
    @DisplayName("Инвертирование массива {1, 2, 3, 4}")
    void invertArray1() {
        // given
        int[] array = {1, 2, 3, 4};

        // when
        int[] invertedArray = Utils.invertArray(array);

        // then
        assertThat(invertedArray)
            .isEqualTo(new int[] {4, 3, 2, 1});
    }

    @Test
    @DisplayName("Инвертирование массива для null")
    void invertArray2() {
        // given
        int[] array = null;

        // when
        int[] invertedArray = Utils.invertArray(array);

        // then
        assertThat(invertedArray)
            .isEqualTo(null);
    }

    @Test
    @DisplayName("Инвертирование массива {}")
    void invertArray3() {
        // given
        int[] array = {};

        // when
        int[] invertedArray = Utils.invertArray(array);

        // then
        assertThat(invertedArray)
            .isEqualTo(new int[] {});
    }

    @Test
    @DisplayName("Является ли число 12345, представленное в виде массива, палиндромом")
    void isArrayPalindrome1() {
        // given
        int[] array = new int[] {1, 2, 3, 4, 5};

        // when
        boolean isArrayPalindrome = Utils.isArrayPalindrome(array);

        // then
        assertThat(isArrayPalindrome)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Является ли число 12321, представленное в виде массива, палиндромом")
    void isArrayPalindrome2() {
        // given
        int[] array = new int[] {1, 2, 3, 2, 1};

        // when
        boolean isArrayPalindrome = Utils.isArrayPalindrome(array);

        // then
        assertThat(isArrayPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Является ли число 0, представленное в виде массива, палиндромом")
    void isArrayPalindrome3() {
        // given
        int[] array = new int[] {0};

        // when
        boolean isArrayPalindrome = Utils.isArrayPalindrome(array);

        // then
        assertThat(isArrayPalindrome)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Является ли null палиндромом")
    void isArrayPalindrome4() {
        // given
        int[] array = null;

        // when
        boolean isArrayPalindrome = Utils.isArrayPalindrome(array);

        // then
        assertThat(isArrayPalindrome)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Расчет потомка числа 11211230 путем суммирования каждой пары соседних цифр")
    void countChild1() {
        // given
        int[] array = new int[] {1, 1, 2, 1, 1, 2, 3, 0};

        // when
        int[] child = Utils.countChild(array);

        // then
        assertThat(child)
            .containsExactly(2, 3, 3, 3)
            .hasSize(4);
    }

    @Test
    @DisplayName("Расчет потомка числа 4022 путем суммирования каждой пары соседних цифр")
    void countChild2() {
        // given
        int[] array = new int[] {4, 0, 2, 2};

        // when
        int[] child = Utils.countChild(array);

        // then
        assertThat(child)
            .containsExactly(4, 4)
            .hasSize(2);
    }

    @Test
    @DisplayName("Расчет потомка числа 11 путем суммирования каждой пары соседних цифр")
    void countChild3() {
        // given
        int[] array = new int[] {1, 1};

        // when
        int[] child = Utils.countChild(array);

        // then
        assertThat(child)
            .containsExactly(2)
            .hasSize(1);
    }

    @Test
    @DisplayName("Расчет потомка для null")
    void countChild4() {
        // given
        int[] array = null;

        // when
        int[] child = Utils.countChild(array);

        // then
        assertThat(child)
            .isEqualTo(null);
    }
}
