package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Task13 {

    private Task13() {
    }

    private static List<Animal> filterAnimalsWithMultiWordNames(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyList();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    public static List<Animal> runTask13(List<Animal> animals) {
        return filterAnimalsWithMultiWordNames(animals);
    }
}
