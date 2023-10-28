package edu.project1;

public enum GameState {
    IN_PROGRESS(""),
    DEFEAT("You lost!"),
    WIN("You won!"),
    GIVE_UP("You gave up!");

    private String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
