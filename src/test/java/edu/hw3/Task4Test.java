package edu.hw3;

import edu.hw3.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Преобразование 2 в римское число")
    void convertToRoman1() {
        // given
        int arabicNumber = 2;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("II");
    }

    @Test
    @DisplayName("Преобразование 12 в римское число")
    void convertToRoman2() {
        // given
        int arabicNumber = 12;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("XII");
    }

    @Test
    @DisplayName("Преобразование 16 в римское число")
    void convertToRoman3() {
        // given
        int arabicNumber = 16;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("XVI");
    }

    @Test
    @DisplayName("Преобразование 3183 в римское число")
    void convertToRoman4() {
        // given
        int arabicNumber = 3183;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("MMMCLXXXIII");
    }

    @Test
    @DisplayName("Преобразование 917 в римское число")
    void convertToRoman5() {
        // given
        int arabicNumber = 917;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("CMXVII");
    }

    @Test
    @DisplayName("Преобразование 5000 в римское число")
    void convertToRoman6() {
        // given
        int arabicNumber = 5000;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("Number must be in the range from 1 to 3999");
    }

    @Test
    @DisplayName("Преобразование 0 в римское число")
    void convertToRoman7() {
        // given
        int arabicNumber = 0;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("Number must be in the range from 1 to 3999");
    }

    @Test
    @DisplayName("Преобразование -100 в римское число")
    void convertToRoman8() {
        // given
        int arabicNumber = -100;

        // when
        String romanNumber = Task4.runTask4(arabicNumber);

        // then
        assertThat(romanNumber)
            .isEqualTo("Number must be in the range from 1 to 3999");
    }
}
