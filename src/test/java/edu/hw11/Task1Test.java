package edu.hw11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Проверка метода toString после применения ByteBuddy")
    void byteBuddyToString() {
        // when
        String result = Task1.runTask1();

        // then
        assertThat(result)
            .isEqualTo("Hello, ByteBuddy!");
    }
}
