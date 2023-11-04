package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Подсчет количества животных каждого вида")
    void countAnimalsByType1() {
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
        Map<Animal.Type, Integer> result = Task3.runTask3(animals);

        // then
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.CAT, 2,
            Animal.Type.DOG, 2,
            Animal.Type.BIRD, 1,
            Animal.Type.FISH, 1,
            Animal.Type.SPIDER, 1
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Подсчет количества животных каждого вида, если есть только 1 вид")
    void countAnimalsByType2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Dog", Animal.Type.CAT, Animal.Sex.F, 3, 8, 10, true),
            new Animal("Bird", Animal.Type.CAT, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.CAT, Animal.Sex.F, 2, 2, 2, false)
        );

        // when
        Map<Animal.Type, Integer> result = Task3.runTask3(animals);

        // then
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.CAT, 4
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Подсчет количества животных каждого вида, среди которых есть null")
    void countAnimalsByType3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));

        // when
        Map<Animal.Type, Integer> result = Task3.runTask3(animals);

        // then
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.BIRD, 1
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Подсчет количества животных каждого вида из пустого списка")
    void countAnimalsByType4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Map<Animal.Type, Integer> result = Task3.runTask3(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Подсчет количества животных каждого вида из списка, равного null")
    void countAnimalsByType5() {
        // given
        List<Animal> animals = null;

        // when
        Map<Animal.Type, Integer> result = Task3.runTask3(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }
}
