package edu.hw2.task3;

public class ConnectionException extends RuntimeException {
    private final String message;
    private final Exception cause;

    public ConnectionException(String message, Exception cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }
}
