package edu.hw5;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Вычисление среднего времени компьютерного сеанса для 2 сеансов")
    void averageSessionDuration1() {
        // given
        List<String> sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20");

        // when
        String result = Task1.runTask1(sessions);

        // then
        assertThat(result)
            .isEqualTo("3ч 40м");
    }

    @Test
    @DisplayName("Вычисление среднего времени компьютерного сеанса для 2 сеансов")
    void averageSessionDuration2() {
        // given
        List<String> sessions = List.of(
            "2022-03-11, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20");

        // when
        String result = Task1.runTask1(sessions);

        // then
        assertThat(result)
            .isEqualTo("15ч 40м");
    }

    @Test
    @DisplayName("Вычисление среднего времени компьютерного сеанса для 3 сеансов")
    void averageSessionDuration3() {
        // given
        List<String> sessions = List.of(
            "2022-03-11, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20",
            "2022-02-01, 21:30 - 2022-04-02, 01:20");

        // when
        String result = Task1.runTask1(sessions);

        // then
        assertThat(result)
            .isEqualTo("20д 3ч 43м");
    }

    @Test
    @DisplayName("Вычисление среднего времени компьютерного сеанса для 1 сеанса")
    void averageSessionDuration4() {
        // given
        List<String> sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50");

        // when
        String result = Task1.runTask1(sessions);

        // then
        assertThat(result)
            .isEqualTo("3ч 30м");
    }

    @Test
    @DisplayName("Вычисление среднего времени компьютерного сеанса, если список равен null")
    void averageSessionDuration5() {
        // given
        List<String> sessions = null;

        // when
        String result = Task1.runTask1(sessions);

        // then
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Вычисление среднего времени компьютерного сеанса, если один из сеансов равен null")
    void averageSessionDuration6() {
        // given
        List<String> sessions = new ArrayList<>();
        sessions.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        sessions.add(null);
        sessions.add("2022-04-01, 21:30 - 2022-04-02, 01:20");

        // when
        String result = Task1.runTask1(sessions);

        // then
        assertThat(result)
            .isEqualTo("3ч 40м");
    }
}
