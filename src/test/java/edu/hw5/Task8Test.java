package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Проверка на нечетную длину 001")
    void hasOddLength1() {
        // given
        String string = "001";

        // when
        Boolean result = Task8.runTask81(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на нечетную длину 0011")
    void hasOddLength2() {
        // given
        String string = "0011";

        // when
        Boolean result = Task8.runTask81(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на нечетную длину null")
    void hasOddLength3() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask81(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на нечетную длину при первом 0 и четную длину при первом 1 100")
    void startsWith0AndOddLengthOrStartsWith1AndEvenLength1() {
        // given
        String string = "100";

        // when
        Boolean result = Task8.runTask82(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на нечетную длину при первом 0 и четную длину при первом 1 1010")
    void startsWith0AndOddLengthOrStartsWith1AndEvenLength2() {
        // given
        String string = "1010";

        // when
        Boolean result = Task8.runTask82(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на нечетную длину при первом 0 и четную длину при первом 1 0001")
    void startsWith0AndOddLengthOrStartsWith1AndEvenLength3() {
        // given
        String string = "0001";

        // when
        Boolean result = Task8.runTask82(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на нечетную длину при первом 0 и четную длину при первом 1 001")
    void startsWith0AndOddLengthOrStartsWith1AndEvenLength4() {
        // given
        String string = "001";

        // when
        Boolean result = Task8.runTask82(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на нечетную длину при первом 0 и четную длину при первом 1 null")
    void startsWith0AndOddLengthOrStartsWith1AndEvenLength5() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask82(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на количество 0 кратных 3 000")
    void numberOf0Multiple3Test1() {
        // given
        String string = "000";

        // when
        Boolean result = Task8.runTask83(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на количество 0 кратных 3 001")
    void numberOf0Multiple3Test2() {
        // given
        String string = "001";

        // when
        Boolean result = Task8.runTask83(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на количество 0 кратных 3 0001000")
    void numberOf0Multiple3Test3() {
        // given
        String string = "0001000";

        // when
        Boolean result = Task8.runTask83(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на количество 0 кратных 3 null")
    void numberOf0Multiple3Test4() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask83(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, которая не 11 или 111, 11")
    void anyStringOtherThan11Or111Test1() {
        // given
        String string = "11";

        // when
        Boolean result = Task8.runTask84(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, которая не 11 или 111, 111")
    void anyStringOtherThan11Or111Test2() {
        // given
        String string = "111";

        // when
        Boolean result = Task8.runTask84(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, которая не 11 или 111, 1000")
    void anyStringOtherThan11Or111Test3() {
        // given
        String string = "1000";

        // when
        Boolean result = Task8.runTask84(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, которая не 11 или 111, null")
    void anyStringOtherThan11Or111Test4() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask84(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой каждый нечетный символ 1, 000")
    void everyOddSymbolIs1Test1() {
        // given
        String string = "000";

        // when
        Boolean result = Task8.runTask85(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой каждый нечетный символ 1, 101")
    void everyOddSymbolIs1Test2() {
        // given
        String string = "101";

        // when
        Boolean result = Task8.runTask85(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, в которой каждый нечетный символ 1, null")
    void everyOddSymbolIs1Test3() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask85(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой минимум два 0 и максимум одна 1, 1000")
    void containsAtLeastTwo0AndNoMoreThanOne1Test1() {
        // given
        String string = "1000";

        // when
        Boolean result = Task8.runTask86(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, в которой минимум два 0 и максимум одна 1, 0100")
    void containsAtLeastTwo0AndNoMoreThanOne1Test2() {
        // given
        String string = "0100";

        // when
        Boolean result = Task8.runTask86(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, в которой минимум два 0 и максимум одна 1, 0010")
    void containsAtLeastTwo0AndNoMoreThanOne1Test3() {
        // given
        String string = "0010";

        // when
        Boolean result = Task8.runTask86(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, в которой минимум два 0 и максимум одна 1, 00110")
    void containsAtLeastTwo0AndNoMoreThanOne1Test4() {
        // given
        String string = "00110";

        // when
        Boolean result = Task8.runTask86(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой минимум два 0 и максимум одна 1, 01")
    void containsAtLeastTwo0AndNoMoreThanOne1Test5() {
        // given
        String string = "01";

        // when
        Boolean result = Task8.runTask86(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой минимум два 0 и максимум одна 1, null")
    void containsAtLeastTwo0AndNoMoreThanOne1Test6() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask86(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой нет 1 подряд, 010")
    void noConsecutive1Test1() {
        // given
        String string = "010";

        // when
        Boolean result = Task8.runTask87(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, в которой нет 1 подряд, 0101")
    void noConsecutive1Test2() {
        // given
        String string = "0101";

        // when
        Boolean result = Task8.runTask87(string);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Проверка на строку, в которой нет 1 подряд, 0110")
    void noConsecutive1Test3() {
        // given
        String string = "0110";

        // when
        Boolean result = Task8.runTask87(string);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Проверка на строку, в которой нет 1 подряд, null")
    void noConsecutive1Test4() {
        // given
        String string = null;

        // when
        Boolean result = Task8.runTask87(string);

        // then
        assertThat(result).isFalse();
    }
}
