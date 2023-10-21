package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Исправление строки \"123456\"")
    void fixString1() {
        // given
        String string = "123456";

        // when
        String fixedString = Task4.runTask4(string);

        // then
        assertThat(fixedString)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Исправление строки \"hTsii  s aimex dpus rtni.g\"")
    void fixString2() {
        // given
        String string = "hTsii  s aimex dpus rtni.g";

        // when
        String fixedString = Task4.runTask4(string);

        // then
        assertThat(fixedString)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Исправление строки \"badce\"")
    void fixString3() {
        // given
        String string = "badce";

        // when
        String fixedString = Task4.runTask4(string);

        // then
        assertThat(fixedString)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Исправление пустой строки")
    void fixString4() {
        // given
        String string = null;

        // when
        String fixedString = Task4.runTask4(string);

        // then
        assertThat(fixedString)
            .isEqualTo(null);
    }
}
