package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task4 {

    private Task4() {
    }

    private static Animal findLongestName(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .max(Comparator.comparing(a -> a.name().length()))
            .orElse(null);
    }

    public static Animal runTask4(List<Animal> animals) {
        return findLongestName(animals);
    }
}
