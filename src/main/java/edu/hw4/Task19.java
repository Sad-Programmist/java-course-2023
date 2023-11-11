package edu.hw4;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Task19 {

    private static final int MIN_AGE = 0;
    private static final int MIN_HEIGHT = 0;
    private static final int MIN_WEIGHT = 0;
    private static final int MAX_AGE = 100;
    private static final int MAX_HEIGHT = 500;
    private static final int MAX_WEIGHT = 5000;

    private Task19() {
    }

    private static Map<String, Set<ValidationError>> findAnimalsWithErrors(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyMap();
        }
        return animals.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(
                Animal::name,
                Task19::validateAnimal,
                (existingSet, newSet) -> {
                    existingSet.addAll(newSet);
                    return existingSet;
                }
            )
            )
            .entrySet().stream()
            .filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    private static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errorsSet = new HashSet<>();
        if (animal.age() < MIN_AGE || animal.age() > MAX_AGE) {
            errorsSet.add(new ValidationError("Age"));
        }
        if (animal.height() < MIN_HEIGHT || animal.height() > MAX_HEIGHT) {
            errorsSet.add(new ValidationError("Height"));
        }
        if (animal.weight() < MIN_WEIGHT || animal.weight() > MAX_WEIGHT) {
            errorsSet.add(new ValidationError("Weight"));
        }
        return errorsSet;
    }

    public static Map<String, Set<ValidationError>> runTask19(List<Animal> animals) {
        return findAnimalsWithErrors(animals);
    }
}
