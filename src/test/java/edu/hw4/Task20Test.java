package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {

    @Test
    @DisplayName("Поиск животного с ошибками из 3")
    void findAnimalsWithErrors1() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 180, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, -5, 50, 200, true),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 3, -30, -100, true)
        );

        // when
        Map<String, String> result = Task20.runTask20(animals);

        // then
        Map<String, String> animalsWithErrors = new HashMap<>();
        animalsWithErrors.put("Lion", "Age");
        animalsWithErrors.put("Dog", "Height, Weight");

        assertThat(result)
            .isEqualTo(animalsWithErrors);
    }

    @Test
    @DisplayName("Поиск животного с ошибками из 3 с одинаковыми именами")
    void findAnimalsWithErrors2() {
        // given
        List<Animal> animals = List.of(
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.F, 4, 45, 200, true),
            new Animal("Tiger", Animal.Type.CAT, Animal.Sex.M, 5, 50, 200, true),
            new Animal("Tiger", Animal.Type.DOG, Animal.Sex.M, 3, 30, 200, true)
        );

        // when
        Map<String, String> result = Task20.runTask20(animals);

        // then
        assertThat(result)
            .isEqualTo(new HashMap<>());
    }

    @Test
    @DisplayName("Поиск животного с ошибками из списка содержащего null")
    void findAnimalsWithErrors3() {
        // given
        List<Animal> animals = new ArrayList<>();
        animals.add(null);
        animals.add(new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, -5, 50, 200, true));

        // when
        Map<String, String> result = Task20.runTask20(animals);

        // then
        Map<String, String> animalsWithErrors = new HashMap<>();
        animalsWithErrors.put("Lion", "Age");

        assertThat(result)
            .isEqualTo(animalsWithErrors);
    }

    @Test
    @DisplayName("Поиск животного с ошибками из пустого списка")
    void findAnimalsWithErrors4() {
        // given
        List<Animal> animals = Collections.emptyList();

        // when
        Map<String, String> result = Task20.runTask20(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }

    @Test
    @DisplayName("Поиск животного с ошибками из списка null")
    void findAnimalsWithErrors5() {
        // given
        List<Animal> animals = null;

        // when
        Map<String, String> result = Task20.runTask20(animals);

        // then
        assertThat(result)
            .isEqualTo(Collections.emptyMap());
    }
}
