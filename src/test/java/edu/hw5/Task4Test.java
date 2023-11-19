package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Проверка пароля 1234")
    void validatePassword1() {
        // given
        String password = "1234";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка пароля 1234~")
    void validatePassword2() {
        // given
        String password = "1234~";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234!")
    void validatePassword3() {
        // given
        String password = "1234!";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234@")
    void validatePassword4() {
        // given
        String password = "1234@";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234#")
    void validatePassword5() {
        // given
        String password = "1234#";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234$")
    void validatePassword6() {
        // given
        String password = "1234$";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234%")
    void validatePassword7() {
        // given
        String password = "1234%";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234^")
    void validatePassword8() {
        // given
        String password = "1234^";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234&")
    void validatePassword9() {
        // given
        String password = "1234&";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234*")
    void validatePassword10() {
        // given
        String password = "1234*";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля 1234|")
    void validatePassword11() {
        // given
        String password = "1234|";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка пароля abc")
    void validatePassword12() {
        // given
        String password = "abc";

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка null")
    void validatePassword13() {
        // given
        String password = null;

        // when
        Boolean result = Task4.runTask4(password);

        // then
        assertThat(result).isFalse();
    }
}
