package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Test
    @DisplayName("Проверка, что строка 010 состоит из 0 и 1, содержит не менее 3 символов, причем третий символ равен 0")
    void hasAtLeast3SymbolsAndThirdIs01() {
        // given
        String string = "010";

        // when
        boolean result = Task7.runTask71(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Проверка, что строка 01111 состоит из 0 и 1, содержит не менее 3 символов, причем третий символ равен 0")
    void hasAtLeast3SymbolsAndThirdIs02() {
        // given
        String string = "01111";

        // when
        boolean result = Task7.runTask71(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка 01 состоит из 0 и 1, содержит не менее 3 символов, причем третий символ равен 0")
    void hasAtLeast3SymbolsAndThirdIs03() {
        // given
        String string = "01";

        // when
        boolean result = Task7.runTask71(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка 2200 состоит из 0 и 1, содержит не менее 3 символов, причем третий символ равен 0")
    void hasAtLeast3SymbolsAndThirdIs04() {
        // given
        String string = "2200";

        // when
        boolean result = Task7.runTask71(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка null состоит из 0 и 1, содержит не менее 3 символов, причем третий символ равен 0")
    void hasAtLeast3SymbolsAndThirdIs05() {
        // given
        String string = null;

        // when
        boolean result = Task7.runTask71(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка 010 состоит из 0 и 1 и начинается и заканчивается одним и тем же символом")
    void startsAndEndsWithSameSymbol1() {
        // given
        String string = "010";

        // when
        boolean result = Task7.runTask72(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Проверка, что строка 1 состоит из 0 и 1 и начинается и заканчивается одним и тем же символом")
    void startsAndEndsWithSameSymbol2() {
        // given
        String string = "1";

        // when
        boolean result = Task7.runTask72(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Проверка, что строка 10000 состоит из 0 и 1 и начинается и заканчивается одним и тем же символом")
    void startsAndEndsWithSameSymbol3() {
        // given
        String string = "10000";

        // when
        boolean result = Task7.runTask72(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка 20002 состоит из 0 и 1 и начинается и заканчивается одним и тем же символом")
    void startsAndEndsWithSameSymbol4() {
        // given
        String string = "20002";

        // when
        boolean result = Task7.runTask72(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка null состоит из 0 и 1 и начинается и заканчивается одним и тем же символом")
    void startsAndEndsWithSameSymbol5() {
        // given
        String string = null;

        // when
        boolean result = Task7.runTask72(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка 010 состоит из 0 и 1 и имеет длину не менее 1 и не более 3")
    void hasLengthNotLessThan1NotMoreThan31() {
        // given
        String string = "010";

        // when
        boolean result = Task7.runTask73(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Проверка, что пустая строка состоит из 0 и 1 и имеет длину не менее 1 и не более 3")
    void hasLengthNotLessThan1NotMoreThan32() {
        // given
        String string = "";

        // when
        boolean result = Task7.runTask73(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка 1 состоит из 0 и 1 и имеет длину не менее 1 и не более 3")
    void hasLengthNotLessThan1NotMoreThan33() {
        // given
        String string = "1";

        // when
        boolean result = Task7.runTask73(string);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Проверка, что строка 22 состоит из 0 и 1 и имеет длину не менее 1 и не более 3")
    void hasLengthNotLessThan1NotMoreThan34() {
        // given
        String string = "22";

        // when
        boolean result = Task7.runTask73(string);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Проверка, что строка null состоит из 0 и 1 и имеет длину не менее 1 и не более 3")
    void hasLengthNotLessThan1NotMoreThan35() {
        // given
        String string = null;

        // when
        boolean result = Task7.runTask73(string);

        // then
        assertThat(result)
            .isFalse();
    }
}
