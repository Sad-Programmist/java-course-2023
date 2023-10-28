package edu.project1;

import java.util.Scanner;

public class ConsoleHangmanGame {
    private final static GameSession GAME_SESSION = new GameSession();

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    public void run() {
        System.out.println("The word: " + GAME_SESSION.getWordState());
        Scanner scanner = new Scanner(System.in);
        while (GAME_SESSION.getGameState() == GameState.IN_PROGRESS) {
            System.out.println("Guess a letter or print \"end\" if you want to give up:");
            String userGuess = scanner.next();
            tryGuess(userGuess);
            printState();
        }
        System.out.println(GAME_SESSION.getGameState().getMessage());
    }

    private void tryGuess(String userGuess) {
        if (userGuess.equals("end")) {
            GAME_SESSION.giveUp();
        } else if (userGuess.length() == 1 && Character.isLetter(userGuess.charAt(0))) {
            GAME_SESSION.guess(userGuess.charAt(0));
        } else {
            GAME_SESSION.wrongLetterFormat();
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private void printState() {
        if (GAME_SESSION.getGameState() != GameState.GIVE_UP) {
            System.out.println(GAME_SESSION.getGuessResult().getMessage());
        }
        System.out.println("The word: " + GAME_SESSION.getWordState());
        System.out.println();
    }
}
