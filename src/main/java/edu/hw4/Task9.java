package edu.hw4;

import java.util.List;
import java.util.Objects;

public class Task9 {

    private Task9() {
    }

    private static Integer countTotalPaws(List<Animal> animals) {
        if (animals == null) {
            return 0;
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .mapToInt(Animal::paws)
            .sum();
    }

    public static Integer runTask9(List<Animal> animals) {
        return countTotalPaws(animals);
    }
}
