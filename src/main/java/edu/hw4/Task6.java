package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task6 {

    private Task6() {
    }

    private static Map<Animal.Type, Animal> findHeaviestAnimalOfEachType(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyMap();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                (a1, a2) -> a1.weight() >= a2.weight() ? a1 : a2
            ));
    }

    public static Map<Animal.Type, Animal> runTask6(List<Animal> animals) {
        return findHeaviestAnimalOfEachType(animals);
    }
}
