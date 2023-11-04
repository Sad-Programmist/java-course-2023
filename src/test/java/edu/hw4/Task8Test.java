package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Поиск самого тяжелого животного ниже k из 4 животных с разным весом и ростом")
    void findHeaviestAnimalBelowK1() {
        // given
        int k = 50;
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 2, 45, 100, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );

        // when
        Optional<Animal> result = Task8.runTask8(animals, k);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)));
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного ниже k из 4 животных с одинаковым весом и разным ростом")
    void findHeaviestAnimalBelowK2() {
        // given
        int k = 50;
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 100, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 100, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 100, true)
        );

        // when
        Optional<Animal> result = Task8.runTask8(animals, k);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 100, true)));
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного ниже k из списка содержащего null")
    void findHeaviestAnimalBelowK3() {
        // given
        int k = 50;
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 45, 200, true));

        // when
        Optional<Animal> result = Task8.runTask8(animals, k);

        // then
        assertThat(result)
            .isEqualTo(Optional.of(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 45, 200, true)));
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного ниже k из пустого списка")
    void findHeaviestAnimalBelowK4() {
        // given
        int k = 50;
        List<Animal> animals = Collections.emptyList();

        // when
        Optional<Animal> result = Task8.runTask8(animals, k);

        // then
        assertThat(result)
            .isEmpty();
    }

    @Test
    @DisplayName("Поиск самого тяжелого животного ниже k из списка null")
    void findHeaviestAnimalBelowK5() {
        // given
        int k = 50;
        List<Animal> animals = null;

        // when
        Optional<Animal> result = Task8.runTask8(animals, k);

        // then
        assertThat(result)
            .isEmpty();
    }
}
