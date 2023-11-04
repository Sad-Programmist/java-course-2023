package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task1 {

    private Task1() {
    }

    private static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyList();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> runTask1(List<Animal> animals) {
        return sortAnimalsByHeight(animals);
    }
}
