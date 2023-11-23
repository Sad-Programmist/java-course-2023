package edu.hw7;

import edu.hw7.task1.Counter;
import edu.hw7.task1.IncrementThread;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IncrementThreadTest {

    @Test
    @DisplayName("Проверка инкремента в одном потоке")
    void singleThreadIncrement() {
        // given
        Counter counter = new Counter();
        IncrementThread incrementThread = new IncrementThread(counter, 5);

        // when
        incrementThread.run();

        // then
        assertThat(counter.getCounter())
            .isEqualTo(5);
    }

    @Test
    @DisplayName("Проверка инкремента в нескольких потоках")
    void multipleThreadsIncrement() throws InterruptedException {
        // given
        Counter counter = new Counter();
        IncrementThread thread1 = new IncrementThread(counter, 10);
        IncrementThread thread2 = new IncrementThread(counter, 15);

        // when
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // then
        assertThat(counter.getCounter())
            .isEqualTo(25);
    }

    @Test
    @DisplayName("Проверка инкремента с отрицательным числом операций")
    void negativeOperationsIncrement() {
        // given
        Counter counter = new Counter();
        IncrementThread incrementThread = new IncrementThread(counter, -5);

        // when
        incrementThread.run();

        // then
        assertThat(counter.getCounter())
            .isEqualTo(0);
    }
}
