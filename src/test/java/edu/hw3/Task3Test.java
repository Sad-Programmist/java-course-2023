package edu.hw3;

import edu.hw3.task3.Task3;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Получение частотного словаря для списка строк")
    void freqDict1() {
        // given
        List<String> elements = Arrays.asList("a", "bb", "a", "bb");

        // when
        Map<String, Integer> freqDict = Task3.runTask3(elements);

        // then
        assertThat(freqDict, is(Map.of(
            "bb", 2,
            "a", 2
        )));
        assertThat(freqDict.size(), is(2));
    }

    @Test
    @DisplayName("Получение частотного словаря для списка строк")
    void freqDict2() {
        // given
        List<String> elements = Arrays.asList("this", "and", "that", "and");

        // when
        Map<String, Integer> freqDict = Task3.runTask3(elements);

        // then
        assertThat(freqDict, is(Map.of(
            "that", 1,
            "and", 2,
            "this", 1
        )));
        assertThat(freqDict.size(), is(3));
    }

    @Test
    @DisplayName("Получение частотного словаря для списка строк")
    void freqDict3() {
        // given
        List<String> elements = Arrays.asList("код", "код", "код", "bug");

        // when
        Map<String, Integer> freqDict = Task3.runTask3(elements);

        // then
        assertThat(freqDict, is(Map.of(
            "код", 3,
            "bug", 1
        )));
        assertThat(freqDict.size(), is(2));
    }

    @Test
    @DisplayName("Получение частотного словаря для списка чисел")
    void freqDict4() {
        // given
        List<Integer> elements = Arrays.asList(1, 1, 2, 2);

        // when
        Map<Integer, Integer> freqDict = Task3.runTask3(elements);

        // then
        assertThat(freqDict, is(Map.of(
            1, 2,
            2, 2
        )));
        assertThat(freqDict.size(), is(2));
    }

    @Test
    @DisplayName("Получение частотного словаря для списка, в котором есть null элементы")
    void freqDict5() {
        // given
        List<Integer> elements = null;

        // when
        Map<Integer, Integer> freqDict = Task3.runTask3(elements);

        // then
        assertThat(freqDict, is(Collections.emptyMap()));
        assertThat(freqDict.size(), is(0));
    }

    @Test
    @DisplayName("Получение частотного словаря для списка, в котором есть null элементы")
    void freqDict6() {
        // given
        List<String> elements = Arrays.asList("first", null, "second", "second");

        // when
        Map<String, Integer> freqDict = Task3.runTask3(elements);

        // then
        assertThat(freqDict, is(Map.of(
            "first", 1,
            "second", 2
        )));
        assertThat(freqDict.size(), is(2));
    }
}
