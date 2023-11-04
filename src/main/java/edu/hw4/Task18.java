package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task18 {

    private Task18() {
    }

    private static Animal findHeaviestFishInLists(List<List<Animal>> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream()
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    public static Animal runTask18(List<List<Animal>> animals) {
        return findHeaviestFishInLists(animals);
    }
}
