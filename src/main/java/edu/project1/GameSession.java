package edu.project1;

import org.apache.commons.lang3.StringUtils;

public class GameSession {
    private final static String WORD = Dictionary.randomWord().toLowerCase();
    private final static int MAX_ATTEMPTS = 5;
    private GameState gameState = GameState.IN_PROGRESS;
    private GuessResult guessResult;
    private String wordState = StringUtils.repeat("*", WORD.length());

    private int mistakes = 0;

    public void guess(char userGuess) {
        char lowerUserGuess = Character.toLowerCase(userGuess);
        if (WORD.indexOf(lowerUserGuess) == -1) {
            mistakes++;
            guessResult = GuessResult.FAILED_GUESS;
            guessResult.setMessage(String.format("Missed, mistake %d out of %d.", mistakes, MAX_ATTEMPTS));
            if (mistakes == MAX_ATTEMPTS) {
                gameState = GameState.DEFEAT;
                wordState = WORD;
            }
        } else if (wordState.indexOf(lowerUserGuess) == -1) {
            guessResult = GuessResult.SUCCESSFUL_GUESS;
            for (int letterIndex = 0; letterIndex < WORD.length(); letterIndex++) {
                if (WORD.charAt(letterIndex) == lowerUserGuess) {
                    wordState = wordState.substring(0, letterIndex) + lowerUserGuess
                        + wordState.substring(letterIndex + 1);
                }
            }
            if (wordState.indexOf('*') == -1) {
                gameState = GameState.WIN;
            }
        } else {
            guessResult = GuessResult.REPEATED_LETTER;
        }
    }

    public void giveUp() {
        gameState = GameState.GIVE_UP;
        wordState = WORD;
    }

    public void wrongLetterFormat() {
        guessResult = GuessResult.WRONG_FORMAT;
    }

    public GameState getGameState() {
        return gameState;
    }

    public String getWordState() {
        return wordState;
    }

    public GuessResult getGuessResult() {
        return guessResult;
    }
}
