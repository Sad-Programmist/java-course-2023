package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task5 {

    private Task5() {
    }

    private static Animal.Sex findMostFrequentSex(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Animal::sex, Collectors.summingInt(animal -> 1)))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    public static Animal.Sex runTask5(List<Animal> animals) {
        return findMostFrequentSex(animals);
    }
}
