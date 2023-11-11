package edu.hw4;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task17 {

    private Task17() {
    }

    @SuppressWarnings("ParameterAssignment")
    private static Boolean compareBiteFrequency(List<Animal> animals) {
        if (animals == null) {
            return false;
        }

        animals = animals.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        long spidersCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .count();

        long dogsCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .count();

        if (spidersCount == 0 || dogsCount == 0) {
            return false;
        }

        long spiderBiteCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        long dogBiteCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        return spiderBiteCount > dogBiteCount;
    }

    public static Boolean runTask17(List<Animal> animals) {
        return compareBiteFrequency(animals);
    }
}
