package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        int randomValue = (int) Math.round(Math.random());
        if (randomValue == 1) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
