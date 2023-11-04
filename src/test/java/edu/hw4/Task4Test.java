package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Поиск животного с самым длинным именем из 3 с разными именами")
    void findLongestName1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, 30, 100, true)
        );

        // when
        Animal result = Task4.runTask4(animals);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true));
    }

    @Test
    @DisplayName("Поиск животного с самым длинным именем из 3 с одинаковыми именами")
    void findLongestName2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true),
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Tiger", Animal.Type.DOG, Animal.Sex.M, 3, 30, 200, true)
        );

        // when
        Animal result = Task4.runTask4(animals);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true));
    }

    @Test
    @DisplayName("Поиск животного с самым длинным именем из списка содержащего null")
    void findLongestName3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true));

        // when
        Animal result = Task4.runTask4(animals);

        // then
        assertThat(result)
            .isEqualTo(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true));
    }

    @Test
    @DisplayName("Поиск животного с самым длинным именем из пустого списка")
    void findLongestName4() {
        // given
        List<Animal> animals = new ArrayList<>();

        // when
        Animal result = Task4.runTask4(animals);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Поиск животного с самым длинным именем из списка null")
    void findLongestName5() {
        // given
        List<Animal> animals = null;

        // when
        Animal result = Task4.runTask4(animals);

        // then
        assertThat(result)
            .isNull();
    }
}
