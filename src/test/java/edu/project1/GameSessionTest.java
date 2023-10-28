package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameSessionTest {

    @Test
    @DisplayName("Угадывание неправильной буквы")
    void guessWrongLetter() {
        // given
        GameSession gameSession = new GameSession();

        // when
        gameSession.guess('y');

        // then
        assertEquals(gameSession.getGuessResult(), GuessResult.FAILED_GUESS);
    }

    @Test
    @DisplayName("Досрочное завершение игры")
    void giveUp() {
        // given
        GameSession gameSession = new GameSession();

        // when
        gameSession.giveUp();

        // then
        assertEquals(gameSession.getGameState(), GameState.GIVE_UP);
    }

    @Test
    @DisplayName("Поражение после неправильной буквы введенной 5 раз")
    void defeat1() {
        // given
        GameSession gameSession = new GameSession();

        // when
        gameSession.guess('y');
        gameSession.guess('y');
        gameSession.guess('y');
        gameSession.guess('y');
        gameSession.guess('y');

        // then
        assertEquals(gameSession.getGameState(), GameState.DEFEAT);
    }

    @Test
    @DisplayName("Отсутствие поражения после неправильной буквы введенной 1 раз")
    void defeat2() {
        // given
        GameSession gameSession = new GameSession();

        // when
        gameSession.guess('y');

        // then
        assertNotEquals(gameSession.getGameState(), GameState.DEFEAT);
    }

    @Test
    @DisplayName("Неверный формат буквы")
    void wrongLetterFormat() {
        // given
        GameSession gameSession = new GameSession();

        // when
        gameSession.wrongLetterFormat();

        // then
        assertEquals(gameSession.getGuessResult(), GuessResult.WRONG_FORMAT);
    }
}
