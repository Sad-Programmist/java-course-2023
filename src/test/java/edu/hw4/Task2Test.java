package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Сортировка списка с 3 животными разного веса")
    void sortByWeightKFirst1() {
        // given
        int k = 2;
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true)
        );

        // when
        List<Animal> result = Task2.runTask2(animals, k);

        // then
        List<Animal> expected = List.of(
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка списка с 3 животными одинакового веса")
    void sortByWeightKFirst2() {
        // given
        int k = 2;
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, 30, 200, true)
        );

        // when
        List<Animal> result = Task2.runTask2(animals, k);

        // then
        List<Animal> expected = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка списка содержащего null")
    void sortByWeightKFirst3() {
        // given
        int k = 2;
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true));

        // when
        List<Animal> result = Task2.runTask2(animals, k);

        // then
        List<Animal> expected = List.of(
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка пустого списка")
    void sortByWeightKFirst4() {
        // given
        int k = 2;
        List<Animal> animals = Collections.emptyList();

        // when
        List<Animal> result = Task2.runTask2(animals, k);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Сортировка списка null")
    void sortByWeightKFirst5() {
        // given
        int k = 2;
        List<Animal> animals = null;

        // when
        List<Animal> result = Task2.runTask2(animals, k);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }
}
