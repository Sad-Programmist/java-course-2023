package edu.hw6;

import edu.hw6.task5.HackerNews;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Получение непустого массива идентификаторов наиболее обсуждаемых статей")
    void hackerNewsTopStories1() {
        // when
        long[] result = HackerNews.hackerNewsTopStories();

        // then
        assertThat(result)
            .isNotEmpty();
    }

    @Test
    @DisplayName("Получение массива идентификаторов наиболее обсуждаемых статей, не равного null")
    void hackerNewsTopStories2() {
        // when
        long[] result = HackerNews.hackerNewsTopStories();

        // then
        assertThat(result)
            .isNotNull();
    }

    @Test
    @DisplayName("Получение названия новости с идентификатором 37570037")
    void news1() {
        // given
        long id = 37570037;

        // when
        String result = HackerNews.news(id);

        // then
        assertThat(result)
            .isEqualTo("JDK 21 Release Notes");
    }

    @Test
    @DisplayName("Получение названия новости с идентификатором 38301761")
    void news2() {
        // given
        long id = 38301761;

        // when
        String result = HackerNews.news(id);

        // then
        assertThat(result)
            .isEqualTo("A New Tool Allows Researchers to Track Damage in Gaza");
    }

    @Test
    @DisplayName("Получение названия новости с идентификатором 1")
    void news3() {
        // given
        long id = 1;

        // when
        String result = HackerNews.news(id);

        // then
        assertThat(result)
            .isEqualTo("Y Combinator");
    }

    @Test
    @DisplayName("Получение названия новости с идентификатором 0")
    void news4() {
        // given
        long id = 0;

        // when
        String result = HackerNews.news(id);

        // then
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Получение названия новости с идентификатором -1")
    void news5() {
        // given
        long id = -1;

        // when
        String result = HackerNews.news(id);

        // then
        assertThat(result)
            .isEqualTo("");
    }
}
