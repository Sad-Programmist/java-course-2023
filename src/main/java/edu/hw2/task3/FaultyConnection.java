package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    public FaultyConnection() {
        LOGGER.info("Faulty connection is opened.");
    }

    @SuppressWarnings("MultipleStringLiterals")
    @Override
    public int execute(String command) throws ConnectionException {
        int randomValue = (int) Math.round(Math.random());
        if (randomValue == 1) {
            LOGGER.error("Command \"" + command + "\" was interrupted because connection is faulty");
            Exception cause = new RuntimeException("There is a faulty connection");
            throw new ConnectionException("Connection is failed", cause);
        }
        LOGGER.info("Command \"" + command + "\" was executed successfully");
        return randomValue;
    }

    @Override
    public void close() {
        LOGGER.info("Faulty connection is closed");
    }
}
