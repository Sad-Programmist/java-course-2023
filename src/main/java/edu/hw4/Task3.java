package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task3 {

    private Task3() {
    }

    private static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyMap();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    public static Map<Animal.Type, Integer> runTask3(List<Animal> animals) {
        return countAnimalsByType(animals);
    }
}
