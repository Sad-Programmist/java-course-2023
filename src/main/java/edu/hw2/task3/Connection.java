package edu.hw2.task3;

public interface Connection extends AutoCloseable {
    int execute(String command);
}
