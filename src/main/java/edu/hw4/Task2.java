package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task2 {

    private Task2() {
    }

    private static List<Animal> sortByWeightKFirst(List<Animal> animals, int k) {
        if (animals == null) {
            return Collections.emptyList();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    public static List<Animal> runTask2(List<Animal> animals, int k) {
        return sortByWeightKFirst(animals, k);
    }
}
