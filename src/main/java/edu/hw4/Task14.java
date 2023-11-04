package edu.hw4;

import java.util.List;
import java.util.Objects;

public class Task14 {

    private Task14() {
    }

    private static boolean hasDogWithHeightGreaterThanK(List<Animal> animals, int k) {
        if (animals == null) {
            return false;
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static boolean runTask14(List<Animal> animals, int k) {
        return hasDogWithHeightGreaterThanK(animals, k);
    }
}
