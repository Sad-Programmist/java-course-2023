package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Распознавание даты в формате 2020-10-10")
    void parseDate1() {
        // given
        String string = "2020-10-10";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.of(2020, 10, 10)));
    }

    @Test
    @DisplayName("Распознавание даты в формате 2020-12-2")
    void parseDate2() {
        // given
        String string = "2020-12-2";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.of(2020, 12, 2)));
    }

    @Test
    @DisplayName("Распознавание даты в формате 1/3/1976")
    void parseDate3() {
        // given
        String string = "1/3/1976";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.of(1976, 3, 1)));
    }

    @Test
    @DisplayName("Распознавание даты в формате 1/3/20")
    void parseDate4() {
        // given
        String string = "1/3/20";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.of(2020, 3, 1)));
    }

    @Test
    @DisplayName("Распознавание даты в формате tomorrow")
    void parseDate5() {
        // given
        String string = "tomorrow";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.now().plusDays(1)));
    }

    @Test
    @DisplayName("Распознавание даты в формате today")
    void parseDate6() {
        // given
        String string = "today";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.now()));
    }

    @Test
    @DisplayName("Распознавание даты в формате yesterday")
    void parseDate7() {
        // given
        String string = "yesterday";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
    }

    @Test
    @DisplayName("Распознавание даты в формате 1 day ago")
    void parseDate8() {
        // given
        String string = "1 day ago";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
    }

    @Test
    @DisplayName("Распознавание даты в формате 2234 days ago")
    void parseDate9() {
        // given
        String string = "2234 days ago";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(LocalDate.now().minusDays(2234)));
    }

    @Test
    @DisplayName("Распознавание даты, если она равна null")
    void parseDate10() {
        // given
        String string = null;

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("Распознавание даты, если она не подходит ни под один формат")
    void parseDate11() {
        // given
        String string = "2020-12-2-ago";

        // when
        Optional<LocalDate> result = Task3.runTask3(string);

        // then
        assertThat(result)
            .isEqualTo(Optional.empty());
    }
}
