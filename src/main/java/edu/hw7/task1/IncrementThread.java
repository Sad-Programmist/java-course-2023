package edu.hw7.task1;

public class IncrementThread extends Thread {
    private final Counter counter;
    private final int operationNumber;

    public IncrementThread(Counter counter, int operationNumber) {
        this.counter = counter;
        this.operationNumber = operationNumber;
    }

    @Override
    public void run() {
        for (int operationIndex = 0; operationIndex < operationNumber; operationIndex++) {
            counter.increment();
        }
    }
}
