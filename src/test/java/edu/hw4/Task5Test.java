package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Определение, животных какого пола больше")
    void findMostFrequentSex1() {
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
        Animal.Sex result = Task5.runTask5(animals);

        // then
        assertThat(result)
            .isEqualTo(Animal.Sex.F);
    }

    @Test
    @DisplayName("Определение, животных какого пола больше, если встречается только 1 пол")
    void findMostFrequentSex2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, 8, 10, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.M, 2, 2, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 0, 0, true),
            new Animal("Another Cat", Animal.Type.CAT, Animal.Sex.M, 4, 6, 5, true),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.M, 2, 4, 3, false)
        );

        // when
        Animal.Sex result = Task5.runTask5(animals);

        // then
        assertThat(result)
            .isEqualTo(Animal.Sex.M);
    }

    @Test
    @DisplayName("Определение, животных какого пола больше, если среди них есть null")
    void findMostFrequentSex3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false));

        // when
        Animal.Sex result = Task5.runTask5(animals);

        // then
        assertThat(result)
            .isEqualTo(Animal.Sex.M);
    }

    @Test
    @DisplayName("Определение, животных какого пола больше, в пустом списке")
    void findMostFrequentSex4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Animal.Sex result = Task5.runTask5(animals);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Определение, животных какого пола больше, если список равен null")
    void findMostFrequentSex5() {
        // given
        List<Animal> animals = null;

        // when
        Animal.Sex result = Task5.runTask5(animals);

        // then
        assertThat(result)
            .isNull();
    }
}
