package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {
    @Test
    @DisplayName("Подсчет сумарного веса животных от k до l лет в списке")
    void calculateTotalWeightByTypeAndAgeRange1() {
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
        Map<Animal.Type, Integer> result = Task15.runTask15(animals, 2, 3);

        // then
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.CAT, 3,
            Animal.Type.DOG, 13,
            Animal.Type.FISH, 2
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Подсчет сумарного веса животных от 10 до 50 лет в списке, где таких животных нет")
    void calculateTotalWeightByTypeAndAgeRange2() {
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
        Map<Animal.Type, Integer> result = Task15.runTask15(animals, 10, 50);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Подсчет сумарного веса животных от 1 до 5 лет в списке, где есть null")
    void calculateTotalWeightByTypeAndAgeRange3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, 1, 101, 1, false));

        // when
        Map<Animal.Type, Integer> result = Task15.runTask15(animals, 1, 5);

        // then
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.BIRD, 1
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Подсчет сумарного веса животных от 1 до 5 лет в пустом списке")
    void calculateTotalWeightByTypeAndAgeRange4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Map<Animal.Type, Integer> result = Task15.runTask15(animals, 1, 5);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Подсчет сумарного веса животных от 1 до 5 лет в списке, который равен null")
    void calculateTotalWeightByTypeAndAgeRange5() {
        // given
        List<Animal> animals = null;

        // when
        Map<Animal.Type, Integer> result = Task15.runTask15(animals, 1, 5);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }
}
