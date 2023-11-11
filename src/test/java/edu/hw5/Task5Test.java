package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Валидация правильного российского номерного знака А123ВЕ777")
    void validateRussianCarNumber1() {
        // given
        String string = "А123ВЕ777";

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Валидация правильного российского номерного знака О777ОО177")
    void validateRussianCarNumber2() {
        // given
        String string = "О777ОО177";

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Валидация неправильного российского номерного знака 123АВЕ777")
    void validateRussianCarNumber3() {
        // given
        String string = "123АВЕ777";

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Валидация неправильного российского номерного знака А123ВГ77")
    void validateRussianCarNumber4() {
        // given
        String string = "А123ВГ77";

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Валидация неправильного российского номерного знака А123ВЕ7777")
    void validateRussianCarNumber5() {
        // given
        String string = "А123ВЕ7777";

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Валидация российского номерного знака, равного null")
    void validateRussianCarNumber6() {
        // given
        String string = null;

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Валидация пустого российского номерного знака")
    void validateRussianCarNumber7() {
        // given
        String string = "";

        // when
        boolean result = Task5.runTask5(string);

        // then
        assertThat(result)
            .isFalse();
    }
}
