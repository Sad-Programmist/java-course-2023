package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Поиск всех пятниц 13-го в 2023 году")
    void findFridayThe13th1() {
        // given
        int year = 2023;

        // when
        List<LocalDate> result = Task2.runTask21(year);

        // then
        List<LocalDate> expected = List.of(
            LocalDate.of(2023, 1, 13),
            LocalDate.of(2023, 10, 13)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск всех пятниц 13-го в 2024 году")
    void findFridayThe13th2() {
        // given
        int year = 2024;

        // when
        List<LocalDate> result = Task2.runTask21(year);

        // then
        List<LocalDate> expected = List.of(
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск всех пятниц 13-го в -1000000000 году")
    void findFridayThe13th3() {
        // given
        int year = -1000000000;

        // when
        List<LocalDate> result = Task2.runTask21(year);

        // then
        List<LocalDate> expected = Collections.emptyList();
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск всех пятниц 13-го в 1000000000 году")
    void findFridayThe13th4() {
        // given
        int year = 1000000000;

        // when
        List<LocalDate> result = Task2.runTask21(year);

        // then
        List<LocalDate> expected = Collections.emptyList();
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Следующая пятница 13-го для 1.12.2022")
    void nextFridayThe13th1() {
        // given
        LocalDate currentDate = LocalDate.of(2022, 12, 1);

        // when
        LocalDate result = Task2.runTask22(currentDate);

        // then
        LocalDate expected = LocalDate.of(2023, 1, 13);
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Следующая пятница 13-го для 13.1.2023")
    void nextFridayThe13th2() {
        // given
        LocalDate currentDate = LocalDate.of(2023, 1, 13);

        // when
        LocalDate result = Task2.runTask22(currentDate);

        // then
        LocalDate expected = LocalDate.of(2023, 10, 13);
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Следующая пятница 13-го для null")
    void nextFridayThe13th3() {
        // given
        LocalDate currentDate = null;

        // when
        LocalDate result = Task2.runTask22(currentDate);

        // then
        assertThat(result)
            .isNull();
    }
}
