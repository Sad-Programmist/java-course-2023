package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    public StableConnection() {
        LOGGER.info("Stable connection is opened");
    }

    @Override
    public int execute(String command) {
        LOGGER.info("Command \"" + command + "\" was executed successfully");
        return 0;
    }

    @Override
    public void close() {
        LOGGER.info("Stable connection is closed");
    }
}
