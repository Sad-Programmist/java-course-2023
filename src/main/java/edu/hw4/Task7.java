package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task7 {

    private Task7() {
    }

    private static Animal findKOldestAnimal(List<Animal> animals, int k) {
        if (animals == null) {
            return null;
        }
        if (k > animals.size()) {
            return null;
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    public static Animal runTask7(List<Animal> animals, int k) {
        return findKOldestAnimal(animals, k);
    }
}
