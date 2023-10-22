package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public ConnectionException updatePackages() throws Exception {
        return tryExecute("apt update && apt upgrade -y");
    }

    ConnectionException tryExecute(String command) throws Exception {
        Connection connection = manager.getConnection();
        for (int attemptIndex = 0; attemptIndex < maxAttempts; attemptIndex++) {
            try {
                if (connection.execute(command) == 0) {
                    break;
                }
            } catch (ConnectionException e) {
                if (connection != null) {
                    connection.close();
                }
                if (attemptIndex == maxAttempts - 1) {
                    return new ConnectionException("Trying to execute is failed", e);
                }
            }
        }
        if (connection != null) {
            connection.close();
        }
        return null;
    }
}
