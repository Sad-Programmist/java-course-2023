package edu.hw3;

import edu.hw3.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Кластеризация ()()()")
    void clusterize1() {
        // given
        String string = "()()()";

        // when
        List<String> clusters = Task2.runTask2(string);

        // then
        assertThat(clusters)
            .isEqualTo(List.of("()", "()", "()"));
    }

    @Test
    @DisplayName("Кластеризация ((()))")
    void clusterize2() {
        // given
        String string = "((()))";

        // when
        List<String> clusters = Task2.runTask2(string);

        // then
        assertThat(clusters)
            .isEqualTo(List.of("((()))"));
    }

    @Test
    @DisplayName("Кластеризация ((()))(())()()(()())")
    void clusterize3() {
        // given
        String string = "((()))(())()()(()())";

        // when
        List<String> clusters = Task2.runTask2(string);

        // then
        assertThat(clusters)
            .isEqualTo(List.of("((()))", "(())", "()", "()", "(()())"));
    }

    @Test
    @DisplayName("Кластеризация ((())())(()(()()))")
    void clusterize4() {
        // given
        String string = "((())())(()(()()))";

        // when
        List<String> clusters = Task2.runTask2(string);

        // then
        assertThat(clusters)
            .isEqualTo(List.of("((())())", "(()(()()))"));
    }

    @Test
    @DisplayName("Кластеризация пустой строки")
    void clusterize5() {
        // given
        String string = "";

        // when
        List<String> clusters = Task2.runTask2(string);

        // then
        assertThat(clusters)
            .isEqualTo(List.of());
    }
}
