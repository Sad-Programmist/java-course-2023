package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task10Test {

    @Test
    @DisplayName("Поиск животных, у которых количество лап не совпадает с возрастом, из 4 животных")
    void expected1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 100, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );

        // when
        List<Animal> result = Task10.runTask10(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск животных, у которых количество лап не совпадает с возрастом, из 4 животных")
    void expected2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 100, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 50, 100, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 40, 100, true)
        );

        // when
        List<Animal> result = Task10.runTask10(animals);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Поиск животных, у которых количество лап не совпадает с возрастом, из списка содержащего null")
    void expected3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 45, 200, true));

        // when
        List<Animal> result = Task10.runTask10(animals);

        // then
        List<Animal> expected = List.of(
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 45, 200, true)
        );
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Поиск животных, у которых количество лап не совпадает с возрастом, из пустого списка")
    void expected4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        List<Animal> result = Task10.runTask10(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Поиск животных, у которых количество лап не совпадает с возрастом, из списка null")
    void expected5() {
        // given
        List<Animal> animals = null;

        // when
        List<Animal> result = Task10.runTask10(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyList());
    }
}
