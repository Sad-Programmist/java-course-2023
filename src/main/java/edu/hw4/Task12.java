package edu.hw4;

import java.util.List;
import java.util.Objects;

public class Task12 {

    private Task12() {
    }

    private static int countOfAnimalsWithWeightGreaterThanHeight(List<Animal> animals) {
        if (animals == null) {
            return 0;
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(a -> a.weight() > a.height())
            .toList()
            .size();
    }

    public static int runTask12(List<Animal> animals) {
        return countOfAnimalsWithWeightGreaterThanHeight(animals);
    }
}
