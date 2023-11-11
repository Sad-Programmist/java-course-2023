package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Определение, 2-ого самого старого животного")
    void findKOldestAnimal1() {
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
        Animal result = Task7.runTask7(animals, 2);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true));
    }

    @Test
    @DisplayName("Определение, 10-ого самого старого животного")
    void findKOldestAnimal2() {
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
        Animal result = Task7.runTask7(animals, 10);

        // then
        assertThat(result)
            .isEqualTo(null);
    }

    @Test
    @DisplayName("Определение, 3-ого самого старого животного, если у всех одинаковый возраст")
    void findKOldestAnimal3() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 2, 8, 10, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.M, 2, 2, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 2, 0, 0, true),
            new Animal("Another Cat", Animal.Type.CAT, Animal.Sex.M, 2, 6, 5, true),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.M, 2, 4, 3, false)
        );

        // when
        Animal result = Task7.runTask7(animals, 3);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 1, 1, false));
    }

    @Test
    @DisplayName("Определение, 1-ого самого старого животного, среди которых есть null")
    void findKOldestAnimal4() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));

        // when
        Animal result = Task7.runTask7(animals, 1);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));
    }

    @Test
    @DisplayName("Определение, 1-ого самого старого животного в пустом списке")
    void findKOldestAnimal5() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Animal result = Task7.runTask7(animals, 1);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Определение, 1-ого самого старого животного, если список равен null")
    void findKOldestAnimal6() {
        // given
        List<Animal> animals = null;

        // when
        Animal result = Task7.runTask7(animals, 1);

        // then
        assertThat(result)
            .isNull();
    }
}
