package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static edu.hw4.Task19.runTask19;

public class Task20 {

    private Task20() {
    }

    private static Map<String, String> findAnimalsWithErrors(List<Animal> animals) {
        if (animals == null) {
            return Collections.emptyMap();
        }
        return runTask19(animals).entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue()
                    .stream()
                    .map(ValidationError::errorField)
                    .collect(Collectors.joining(", "))
            ));
    }

    public static Map<String, String> runTask20(List<Animal> animals) {
        return findAnimalsWithErrors(animals);
    }
}
