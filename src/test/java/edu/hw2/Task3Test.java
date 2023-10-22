package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Создание исполнителя команд на основе Default Connection Manager")
    void defaultConnection() throws Exception {
        // given
        PopularCommandExecutor defaultExecutor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);
        ConnectionException connectionException = defaultExecutor.updatePackages();

        // when
        if (connectionException != null) {
            String exceptionString = connectionException.getMessage();

            // then
            assertThat(exceptionString)
                .isEqualTo("Trying to execute is failed");
        } else {
            assertThat(connectionException)
                .isNull();
        }
    }

    @Test
    @DisplayName("Создание исполнителя команд на основе Faulty Connection Manager")
    void faultyConnection() throws Exception {
        // given
        PopularCommandExecutor faultyExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        ConnectionException connectionException = faultyExecutor.updatePackages();

        // when
        if (connectionException != null) {
            String exceptionString = connectionException.getMessage();

            // then
            assertThat(exceptionString)
                .isEqualTo("Trying to execute is failed");
        } else {
            assertThat(connectionException)
                .isNull();
        }
    }
}
