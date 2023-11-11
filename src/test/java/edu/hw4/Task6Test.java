package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Поиск самого тяжелого животного каждого типа из 4 животных с разным весом")
    void findHeaviestAnimalOfEachType1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );

        // when
        Map<Animal.Type, Animal> result = Task6.runTask6(animals);

        // then
        Map<Animal.Type, Animal> expected = Map.of(
            Animal.Type.CAT,
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            Animal.Type.DOG,
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного каждого типа из 4 животных с одинаковым весом")
    void findHeaviestAnimalOfEachType2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 100, true)
        );

        // when
        Map<Animal.Type, Animal> result = Task6.runTask6(animals);

        // then
        Map<Animal.Type, Animal> expected = Map.of(
            Animal.Type.CAT,
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true),
            Animal.Type.DOG,
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true)
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного каждого типа из списка содержащего null")
    void findHeaviestAnimalOfEachType3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true));

        // when
        Map<Animal.Type, Animal> result = Task6.runTask6(animals);

        // then
        Map<Animal.Type, Animal> expected = Map.of(
            Animal.Type.CAT,
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true)
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного каждого типа из пустого списка")
    void indHeaviestAnimalOfEachType4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Map<Animal.Type, Animal> result = Task6.runTask6(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного каждого типа из списка null")
    void indHeaviestAnimalOfEachType5() {
        // given
        List<Animal> animals = null;

        // when
        Map<Animal.Type, Animal> result = Task6.runTask6(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }
}
