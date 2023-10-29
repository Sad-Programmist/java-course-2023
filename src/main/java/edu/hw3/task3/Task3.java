package edu.hw3.task3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    private Task3() {
    }

    private static <T> Map<T, Integer> freqDict(List<T> elements) {
        if (elements == null) {
            return Collections.emptyMap();
        }

        Map<T, Integer> frequencyMap = new HashMap<>();

        for (T element : elements) {
            if (element != null) {
                frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            }
        }

        return frequencyMap;
    }

    public static <T> Map<T, Integer> runTask3(List<T> elements) {
        return freqDict(elements);
    }
}
