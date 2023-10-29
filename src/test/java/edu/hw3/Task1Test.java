package edu.hw3;

import edu.hw3.task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Применение шифра Атбаша к строке \"Hello world!\"")
    void atbash1() {
        // given
        String startString = "Hello world!";

        // when
        String newString = Task1.runTask1(startString);

        // then
        assertThat(newString)
            .isEqualTo("Svool dliow!");
    }

    @Test
    @DisplayName("Применение шифра Атбаша к цитате")
    void atbash2() {
        // given
        String startString = "Any fool can write code that a computer can understand. " +
            "Good programmers write code that humans can understand. ― Martin Fowler";

        // when
        String newString = Task1.runTask1(startString);

        // then
        assertThat(newString)
            .isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
                "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("Применение шифра Атбаша к русским буквам")
    void atbash3() {
        // given
        String startString = "Привет, мир!";

        // when
        String newString = Task1.runTask1(startString);

        // then
        assertThat(newString)
            .isEqualTo("Привет, мир!");
    }

    @Test
    @DisplayName("Применение шифра Атбаша к строке из цифр")
    void atbash4() {
        // given
        String startString = "123 456 7";

        // when
        String newString = Task1.runTask1(startString);

        // then
        assertThat(newString)
            .isEqualTo("123 456 7");
    }

    @Test
    @DisplayName("Применение шифра Атбаша к строке, равной null")
    void atbash5() {
        // given
        String startString = null;

        // when
        String newString = Task1.runTask1(startString);

        // then
        assertThat(newString)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Применение шифра Атбаша к пустой строке")
    void atbash6() {
        // given
        String startString = "";

        // when
        String newString = Task1.runTask1(startString);

        // then
        assertThat(newString)
            .isEqualTo("");
    }
}
