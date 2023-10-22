package edu.project1;

public enum GuessResult {
    SUCCESSFUL_GUESS("Hit!"),
    FAILED_GUESS("Missed!"),
    REPEATED_LETTER("This is a repeated letter!"),
    WRONG_FORMAT("Wrong letter format!");

    private String message;

    GuessResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
