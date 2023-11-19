package edu.project3;

import edu.project3.utils.DateParseUtils;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DateParseUtilsTest {

    @Test
    @DisplayName("Преобразование даты из формата CLF в формат ODT")
    void fromCLFtoODT1() {
        // given
        String date = "17/May/2015:08:05:32 +0000";

        // when
        OffsetDateTime result = DateParseUtils.fromCLFtoODT(date);

        // then
        assertThat(result)
            .isEqualTo(OffsetDateTime.of(2015, 5, 17, 8, 5, 32, 0, ZoneOffset.UTC));
    }

    @Test
    @DisplayName("Преобразование даты, равной null, из формата CLF в формат ODT")
    void fromCLFtoODT2() {
        // given
        String date = null;

        // when
        OffsetDateTime result = DateParseUtils.fromCLFtoODT(date);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Преобразование даты 'wrong' из формата CLF в формат ODT")
    void fromCLFtoODT3() {
        // given
        String date = "wrong";

        // when
        OffsetDateTime result = DateParseUtils.fromCLFtoODT(date);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Преобразование даты из формата ISO в формат ODT")
    void fromISOtoODT1() {
        // given
        String date = "2023-08-31";

        // when
        OffsetDateTime result = DateParseUtils.fromISOtoODT(date);

        // then
        assertThat(result)
            .isEqualTo(OffsetDateTime.of(2023, 8, 31, 0, 0, 0, 0, ZoneOffset.UTC));
    }

    @Test
    @DisplayName("Преобразование даты, равной null, из формата ISO в формат ODT")
    void fromISOtoODT2() {
        // given
        String date = null;

        // when
        OffsetDateTime result = DateParseUtils.fromISOtoODT(date);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Преобразование даты 'wrong' из формата ISO в формат ODT")
    void fromISOtoODT3() {
        // given
        String date = "wrong";

        // when
        OffsetDateTime result = DateParseUtils.fromISOtoODT(date);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Преобразование даты из формата ODT в формат ISO")
    void fromODTtoISO1() {
        // given
        OffsetDateTime date = OffsetDateTime.of(2015, 5, 17, 8, 5, 32, 0, ZoneOffset.UTC);

        // when
        String result = DateParseUtils.fromODTtoISO(date);

        // then
        assertThat(result)
            .isEqualTo("2015-05-17");
    }

    @Test
    @DisplayName("Преобразование даты, равной null, из формата ODT в формат ISO")
    void fromODTtoISO2() {
        // given
        OffsetDateTime date = null;

        // when
        String result = DateParseUtils.fromODTtoISO(date);

        // then
        assertThat(result)
            .isNull();
    }
}
