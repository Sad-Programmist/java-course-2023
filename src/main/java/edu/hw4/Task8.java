package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Task8 {

    private Task8() {
    }

    private static Optional<Animal> findHeaviestAnimalBelowK(List<Animal> animals, int k) {
        if (animals == null) {
            return Optional.empty();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Optional<Animal> runTask8(List<Animal> animals, int k) {
        return findHeaviestAnimalBelowK(animals, k);
    }
}
