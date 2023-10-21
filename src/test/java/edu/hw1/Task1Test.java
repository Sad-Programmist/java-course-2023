package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Рассчет длины видео 01:00 в секундах")
    void minutesToSeconds1() {
        // given
        String videoLength = "01:00";

        // when
        int secondsVideoLength = Task1.runTask1(videoLength);

        // then
        assertThat(secondsVideoLength)
            .isEqualTo(60);
    }

    @Test
    @DisplayName("Рассчет длины видео 13:56 в секундах")
    void minutesToSeconds2() {
        // given
        String videoLength = "13:56";

        // when
        int secondsVideoLength = Task1.runTask1(videoLength);

        // then
        assertThat(secondsVideoLength)
            .isEqualTo(836);
    }

    @Test
    @DisplayName("Рассчет длины видео 10:60 в секундах")
    void minutesToSeconds3() {
        // given
        String videoLength = "10:60";

        // when
        int secondsVideoLength = Task1.runTask1(videoLength);

        // then
        assertThat(secondsVideoLength)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Рассчет длины видео -10:10 в секундах")
    void minutesToSeconds4() {
        // given
        String videoLength = "-10:10";

        // when
        int secondsVideoLength = Task1.runTask1(videoLength);

        // then
        assertThat(secondsVideoLength)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Рассчет длины видео 999:59 в секундах")
    void minutesToSeconds5() {
        // given
        String videoLength = "999:59";

        // when
        int secondsVideoLength = Task1.runTask1(videoLength);

        // then
        assertThat(secondsVideoLength)
            .isEqualTo(59999);
    }

    @Test
    @DisplayName("Рассчет длины видео null в секундах")
    void minutesToSeconds6() {
        // given
        String videoLength = null;

        // when
        int secondsVideoLength = Task1.runTask1(videoLength);

        // then
        assertThat(secondsVideoLength)
            .isEqualTo(-1);
    }
}
