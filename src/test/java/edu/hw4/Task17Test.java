package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки")
    void compareBiteFrequency1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.DOG, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 10, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 0, 0, true),
            new Animal("Another Cat", Animal.Type.SPIDER, Animal.Sex.F, 4, 6, 5, true),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 2, 4, 3, false)
        );

        // when
        boolean result = Task17.runTask17(animals);

        // then
        assertThat(result)
            .isTrue();
    }

    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки (данных недоставточно)")
    void compareBiteFrequency2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Dog", Animal.Type.CAT, Animal.Sex.F, 3, 8, 10, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Spider", Animal.Type.FISH, Animal.Sex.M, 1, 0, 0, true),
            new Animal("Another Cat", Animal.Type.CAT, Animal.Sex.F, 4, 6, 5, true),
            new Animal("Big Dog", Animal.Type.BIRD, Animal.Sex.F, 2, 4, 3, false)
        );

        // when
        boolean result = Task17.runTask17(animals);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки (в списке есть null)")
    void compareBiteFrequency3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Bird who can fly", Animal.Type.BIRD, Animal.Sex.M, 1, 101, 1, false));

        // when
        boolean result = Task17.runTask17(animals);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки (список пуст)")
    void compareBiteFrequency4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        boolean result = Task17.runTask17(animals);

        // then
        assertThat(result)
            .isFalse();
    }

    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки (список равен null)")
    void compareBiteFrequency5() {
        // given
        List<Animal> animals = null;

        // when
        boolean result = Task17.runTask17(animals);

        // then
        assertThat(result)
            .isFalse();
    }
}
