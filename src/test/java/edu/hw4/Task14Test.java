package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task14Test {

    @Test
    @DisplayName("Есть ли собака выше k из 4 животных")
    void hasDogWithHeightGreaterThanK1() {
        // given
        int k = 35;
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 100, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 30, 100, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 40, 150, true)
        );

        // when
        boolean result = Task14.runTask14(animals, k);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Есть ли собака выше k из 4 животных")
    void hasDogWithHeightGreaterThanK2() {
        // given
        int k = 35;
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 1, 45, 30, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 1, 50, 30, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 30, 30, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 1, 30, 30, true)
        );

        // when
        boolean result = Task14.runTask14(animals, k);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Есть ли собака выше k из списка содержащего null")
    void hasDogWithHeightGreaterThanK3() {
        // given
        int k = 35;
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 45, 200, true));

        // when
        boolean result = Task14.runTask14(animals, k);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Есть ли собака выше k из пустого списка")
    void hasDogWithHeightGreaterThanK4() {
        // given
        int k = 35;
        List<Animal> animals = Collections.emptyList();

        // when
        boolean result = Task14.runTask14(animals, k);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Есть ли собака выше k из списка null")
    void hasDogWithHeightGreaterThanK5() {
        // given
        int k = 35;
        List<Animal> animals = null;

        // when
        boolean result = Task14.runTask14(animals, k);

        // then
        assertThat(result)
            .isFalse();
    }
}
