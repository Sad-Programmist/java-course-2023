package edu.hw7;

import edu.hw7.task1.Counter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CounterTest {

    @Test
    @DisplayName("Инкремент счетчика 1 раз")
    void incrementCounter1() {
        // given
        Counter counter = new Counter();

        // when
        counter.increment();

        // then
        assertThat(counter.getCounter())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Инкремент счетчика 3 раза")
    void incrementCounter2() {
        // given
        Counter counter = new Counter();

        // when
        counter.increment();
        counter.increment();
        counter.increment();

        // then
        assertThat(counter.getCounter())
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Инкремент счетчика 0 раз")
    void incrementCounter3() {
        // given
        Counter counter = new Counter();

        // then
        assertThat(counter.getCounter())
            .isEqualTo(0);
    }
}
