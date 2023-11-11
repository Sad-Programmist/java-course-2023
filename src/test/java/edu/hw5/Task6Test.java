package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Строка abcabcabc и подстрока abc")
    void isSubstring1() {
        // given
        String string = "abcabcabc";
        String substring = "abc";

        // when
        Boolean result = Task6.runTask6(substring, string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Строка abcabcabc и подстрока abcabc")
    void isSubstring2() {
        // given
        String string = "abcabcabc";
        String substring = "abc";

        // when
        Boolean result = Task6.runTask6(substring, string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Строка abcabcabc и подстрока acb")
    void isSubstring3() {
        // given
        String string = "abcabcabc";
        String substring = "acb";

        // when
        Boolean result = Task6.runTask6(substring, string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Строка null и подстрока acb")
    void isSubstring4() {
        // given
        String string = null;
        String substring = "acb";

        // when
        Boolean result = Task6.runTask6(substring, string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Строка abcabcabc и подстрока null")
    void isSubstring5() {
        // given
        String string = "abcabcabc";
        String substring = null;

        // when
        Boolean result = Task6.runTask6(substring, string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Строка null и подстрока null")
    void isSubstring6() {
        // given
        String string = null;
        String substring = null;

        // when
        Boolean result = Task6.runTask6(substring, string);

        // then
        assertThat(result).isFalse();
    }

}
