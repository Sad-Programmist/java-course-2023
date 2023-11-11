package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {

    @Test
    @DisplayName("Поиск самой тяжелой рыбы из 3 списков")
    void findHeaviestFishInLists1() {
        // given
        List<Animal> animals1 = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true)
        );
        List<Animal> animals2 = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 30, 100, true),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 4, 10, 1, true)
        );
        List<Animal> animals3 = List.of(
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 5, 50, 20, true),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 4, 10, 3, true)
        );

        List<List<Animal>> animals = List.of(animals1, animals2, animals3);

        // when
        Animal result = Task18.runTask18(animals);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 4, 10, 3, true));
    }

    @Test
    @DisplayName("Поиск самой тяжелой рыбы из 3 списков")
    void findHeaviestFishInLists2() {
        // given
        List<Animal> animals1 = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true)
        );
        List<Animal> animals2 = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 30, 100, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 4, 10, 1, true)
        );
        List<Animal> animals3 = List.of(
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 5, 50, 20, true),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 4, 10, 3, true)
        );

        List<List<Animal>> animals = List.of(animals1, animals2, animals3);

        // when
        Animal result = Task18.runTask18(animals);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Поиск самой тяжелой рыбы из 2 списков один из которых null")
    void findHeaviestFishInLists3() {
        // given
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(null);
        animals1.add(new Animal("Fish", Animal.Type.FISH, Animal.Sex.M, 4, 10, 3, true));

        List<List<Animal>> animals = List.of(animals1);

        // when
        Animal result = Task18.runTask18(animals);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Fish", Animal.Type.FISH, Animal.Sex.M, 4, 10, 3, true));
    }

    @Test
    @DisplayName("Поиск самой тяжелой рыбы из пустого списка")
    void findHeaviestFishInLists4() {
        // given
        List<List<Animal>> animals = Collections.emptyList();

        // when
        Animal result = Task18.runTask18(animals);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Поиск самой тяжелой рыбы из списка содержащего пустой список")
    void findHeaviestFishInLists5() {
        // given
        List<Animal> animals1 = Collections.emptyList();
        List<List<Animal>> animals = List.of(animals1);

        // when
        Animal result = Task18.runTask18(animals);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Поиск самой тяжелой рыбы из списка null")
    void findHeaviestFishInLists6() {
        // given
        List<List<Animal>> animals = null;

        // when
        Animal result = Task18.runTask18(animals);

        // then
        assertThat(result)
            .isNull();
    }
}
