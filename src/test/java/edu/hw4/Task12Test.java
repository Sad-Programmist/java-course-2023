package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task12Test {
    @Test
    @DisplayName("Количество животных, у которых вес больше чем рост, из 4 животных")
    void countOfAnimalsWithWeightGreaterThanHeight1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 100, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );

        // when
        int result = Task12.runTask12(animals);

        // then
        assertThat(result)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Количество животных, у которых вес больше чем рост, из 4 животных")
    void countOfAnimalsWithWeightGreaterThanHeight2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 1, 45, 30, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 1, 50, 30, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 35, 30, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 1, 40, 30, true)
        );

        // when
        int result = Task12.runTask12(animals);

        // then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Количество животных, у которых вес больше чем рост, из списка содержащего null")
    void countOfAnimalsWithWeightGreaterThanHeight3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 45, 200, true));

        // when
        int result = Task12.runTask12(animals);

        // then
        assertThat(result)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Количество животных, у которых вес больше чем рост, из пустого списка")
    void countOfAnimalsWithWeightGreaterThanHeight4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        int result = Task12.runTask12(animals);

        // then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Количество животных, у которых вес больше чем рост, из списка null")
    void countOfAnimalsWithWeightGreaterThanHeight5() {
        // given
        List<Animal> animals = null;

        // when
        int result = Task12.runTask12(animals);

        // then
        assertThat(result)
            .isEqualTo(0);
    }
}
