package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Task10 {

    private Task10() {
    }

    private static List<Animal> animalsWithAgeMismatchPaws(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyList();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.paws() != a.age())
            .toList();
    }

    public static List<Animal> runTask10(List<Animal> animals) {
        return animalsWithAgeMismatchPaws(animals);
    }
}
