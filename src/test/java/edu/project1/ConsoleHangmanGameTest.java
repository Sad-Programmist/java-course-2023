package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleHangmanGameTest {
    private ConsoleHangmanGame hangmanGame;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        hangmanGame = new ConsoleHangmanGame();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void simulateUserInput(String... input) {
        String inputString = String.join(System.lineSeparator(), input);
        InputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("Завершение игры досрочно")
    void testTryGuessGiveUp() {
        // given
        simulateUserInput("end");

        // when
        hangmanGame.run();

        // then
        assertTrue(outputStream.toString().contains(GameState.GIVE_UP.getMessage()));
    }

    @Test
    @DisplayName("Угадывание правильной буквы")
    void testTryGuessCorrectLetter() {
        // given
        simulateUserInput("a");

        // when
        hangmanGame.run();

        // then
        assertTrue(outputStream.toString().contains(GameState.IN_PROGRESS.getMessage()));
    }

    @Test
    @DisplayName("Угадывание неправильной буквы")
    void testTryGuessIncorrectLetter() {
        // given
        simulateUserInput("y", "end");

        // when
        hangmanGame.run();

        // then
        assertTrue(outputStream.toString().contains(GameState.IN_PROGRESS.getMessage()));
    }

    @Test
    @DisplayName("Ввод цифры")
    void testTryGuessWrongFormat1() {
        // given
        simulateUserInput("1", "end");

        // when
        hangmanGame.run();

        // then
        assertTrue(outputStream.toString().contains(GameState.IN_PROGRESS.getMessage()));

    }

    @Test
    @DisplayName("Ввод строки, длиной больше 1")
    void testTryGuessWrongFormat2() {
        // given
        simulateUserInput("jk", "end");

        // when
        hangmanGame.run();

        // then
        assertTrue(outputStream.toString().contains(GameState.IN_PROGRESS.getMessage()));

    }

}
