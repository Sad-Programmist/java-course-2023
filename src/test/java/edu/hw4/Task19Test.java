package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task19Test {
    @Test
    @DisplayName("Получение животных, в записях о которых есть ошибки")
    void findAnimalsWithErrors1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, -2, 5, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2000, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 10, 10, true),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 4, 6, -5, true),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 2, 4, 3, false)
        );

        // when
        Map<String, Set<ValidationError>> result = Task19.runTask19(animals);

        // then
        Map<String, Set<ValidationError>> expected = Map.of(
            "Cat", Set.of(new ValidationError("Age"), new ValidationError("Weight")),
            "Fish", Set.of(new ValidationError("Height"))
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Получение животных, в записях о которых есть ошибки, если таких нет")
    void findAnimalsWithErrors2() {
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
        Map<String, Set<ValidationError>> result = Task19.runTask19(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Получение животных, в записях о которых есть ошибки, если в списке есть null")
    void findAnimalsWithErrors3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, -1, 101, 1, false));

        // when
        Map<String, Set<ValidationError>> result = Task19.runTask19(animals);

        // then
        Map<String, Set<ValidationError>> expected = Map.of(
            "Bird who can fly", Set.of(new ValidationError("Age"))
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Получение животных, в записях о которых есть ошибки, если список пуст")
    void findAnimalsWithErrors4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Map<String, Set<ValidationError>> result = Task19.runTask19(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Получение животных, в записях о которых есть ошибки, если список равен null")
    void findAnimalsWithErrors5() {
        // given
        List<Animal> animals = null;

        // when
        Map<String, Set<ValidationError>> result = Task19.runTask19(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }
}
