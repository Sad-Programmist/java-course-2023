package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task16 {

    private Task16() {
    }

    private static List<Animal> animalsSortedByTypeSexName(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyList();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name)
            )
            .toList();
    }

    public static List<Animal> runTask16(List<Animal> animals) {
        return animalsSortedByTypeSexName(animals);
    }
}
