package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {
    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов")
    void filterAnimalsWithMultiWordNames1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat cat", Animal.Type.CAT, Animal.Sex.M, 2, 105, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 101, 10, true),
            new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 0, 0, true),
            new Animal("Another Good Cat", Animal.Type.CAT, Animal.Sex.F, 4, 150, 5, true),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 2, 4, 3, false)
        );

        // when
        List<Animal> result = Task13.runTask13(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Another Good Cat", Animal.Type.CAT, Animal.Sex.F, 4, 150, 5, true)
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов, если таких нет")
    void filterAnimalsWithMultiWordNames2() {
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
        List<Animal> result = Task13.runTask13(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов, если в списке есть null")
    void filterAnimalsWithMultiWordNames3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, 1, 101, 1, false));

        // when
        List<Animal> result = Task13.runTask13(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, 1, 101, 1, false)
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов, если список пуст")
    void filterAnimalsWithMultiWordNames4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        List<Animal> result = Task13.runTask13(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов, если список равен null")
    void filterAnimalsWithMultiWordNames5() {
        // given
        List<Animal> animals = null;

        // when
        List<Animal> result = Task13.runTask13(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }
}
