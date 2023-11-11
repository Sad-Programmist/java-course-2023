package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task15 {

    private Task15() {
    }

    private static Map<Animal.Type, Integer> calculateTotalWeightByTypeAndAgeRange(List<Animal> animals, int k, int l) {
        if (animals == null) {
            return Collections.emptyMap();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static Map<Animal.Type, Integer> runTask15(List<Animal> animals, int k, int l) {
        return calculateTotalWeightByTypeAndAgeRange(animals, k, l);
    }
}
