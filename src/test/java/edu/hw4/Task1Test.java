package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Сортировка животных по росту")
    void sortAnimalsByHeight1() {
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
        List<Animal> sortedAnimals = Task1.runTask1(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 0, 0, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 2, 4, 3, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Another Cat", Animal.Type.CAT, Animal.Sex.F, 4, 6, 5, true),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true)
        );

        assertThat(sortedAnimals)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка животных с одинаковым ростом")
    void sortAnimalsByHeight2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 0, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 2, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false)
        );

        // when
        List<Animal> sortedAnimals = Task1.runTask1(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 0, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 2, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false)
        );

        assertThat(sortedAnimals)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка списка животных, в котором есть null, по росту")
    void sortAnimalsByHeight3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));

        // when
        List<Animal> sortedAnimals = Task1.runTask1(animals);

        // then
        List<Animal> expected = new ArrayList<>();
        expected.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));

        assertThat(sortedAnimals)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка списка с одним животным")
    void sortAnimalsByHeight4() {
        // given
        List<Animal> animals = List.of(
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true)
        );

        // when
        List<Animal> sortedAnimals = Task1.runTask1(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true)
        );

        assertThat(sortedAnimals)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка списка, равного null")
    void sortAnimalsByHeight5() {
        // given
        List<Animal> animals = null;

        // when
        List<Animal> sortedAnimals = Task1.runTask1(animals);

        // then
        assertThat(sortedAnimals)
            .isEqualTo(Collections.emptyList());
    }
}
