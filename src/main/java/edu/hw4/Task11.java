package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Task11 {

    private Task11() {
    }

    @SuppressWarnings("MagicNumber")
    private static List<Animal> filterBitingAnimalsAboveHeight(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyList();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
    }

    public static List<Animal> runTask11(List<Animal> animals) {
        return filterBitingAnimalsAboveHeight(animals);
    }
}
