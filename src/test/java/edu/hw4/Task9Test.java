package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {
    @Test
    @DisplayName("Подсчет общего кол-ва лап у животных в списке")
    void countTotalPaws1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 0, 0, true),
            new Animal("Another Cat", Animal.Type.CAT, Animal.Sex.F, 4, 6, 5, true),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 2, 4, 3, false)
        );

        // when
        int result = Task9.runTask9(animals);

        // then
        assertThat(result)
            .isEqualTo(26);
    }

    @Test
    @DisplayName("Подсчет общего кол-ва лап у животных без лап")
    void countTotalPaws2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false)
        );

        // when
        int result = Task9.runTask9(animals);

        // then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Подсчет общего кол-ва лап у животных в списке, где есть null")
    void countTotalPaws3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));

        // when
        int result = Task9.runTask9(animals);

        // then
        assertThat(result)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("Подсчет общего кол-ва лап у животных в пустом списке")
    void countTotalPaws4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        int result = Task9.runTask9(animals);

        // then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Подсчет общего кол-ва лап у животных в списке, который равен null")
    void countTotalPaws5() {
        // given
        List<Animal> animals = null;

        // when
        int result = Task9.runTask9(animals);

        // then
        assertThat(result)
            .isEqualTo(0);
    }
}
