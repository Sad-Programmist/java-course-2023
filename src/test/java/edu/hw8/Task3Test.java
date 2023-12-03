package edu.hw8;

import edu.hw8.task3.MultiThreadedPasswordCracker;
import edu.hw8.task3.SingleThreadedPasswordCracker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Проверка однопоточного перебирателя паролей")
    void singleThreadedPasswordCracker() {
        // given
        List<String> dbStrings = List.of(
            "a.v.petrov  202cb962ac59075b964b07152d234b70",
            "v.v.belov   900150983cd24fb0d6963f7d28e17f72",
            "a.s.ivanov  a9f8b290f20a314b0875578f70809917",
            "k.p.maslov  84206a436129b50ca9d868d99e33e36b"
        );

        // when
        Map<String, String> result = SingleThreadedPasswordCracker.crackPassword(dbStrings);

        // then
        Map<String, String> expected =
            Map.of("a.s.ivanov", "9r4",
                "a.v.petrov", "123",
                "k.p.maslov", "e66",
                "v.v.belov", "abc");
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка многопоточного перебирателя паролей")
    void multiThreadedPasswordCracker() {
        // given
        List<String> dbStrings = List.of(
            "a.v.petrov  202cb962ac59075b964b07152d234b70",
            "v.v.belov   900150983cd24fb0d6963f7d28e17f72",
            "a.s.ivanov  a9f8b290f20a314b0875578f70809917",
            "k.p.maslov  84206a436129b50ca9d868d99e33e36b"
        );
        int threadNumber = 5;

        // when
        Map<String, String> result = MultiThreadedPasswordCracker.crackPassword(dbStrings, threadNumber);

        // then
        Map<String, String> expected =
            Map.of("a.s.ivanov", "9r4",
                "a.v.petrov", "123",
                "k.p.maslov", "e66",
                "v.v.belov", "abc");
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка однопоточного перебирателя паролей с null")
    void singleThreadedPasswordCracker2() {
        // given
        List<String> dbStrings = null;

        // when
        Map<String, String> result = SingleThreadedPasswordCracker.crackPassword(dbStrings);

        // then
        assertThat(result)
            .isEqualTo(Map.of());
    }

    @Test
    @DisplayName("Проверка многопоточного перебирателя паролей с null")
    void multiThreadedPasswordCracker2() {
        // given
        List<String> dbStrings = null;
        int threadNumber = 5;

        // when
        Map<String, String> result = MultiThreadedPasswordCracker.crackPassword(dbStrings, threadNumber);

        // then
        assertThat(result)
            .isEqualTo(Map.of());
    }
}
