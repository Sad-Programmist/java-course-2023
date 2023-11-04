package edu.hw3;

import edu.hw3.task7.NullableKeyComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Добавление в TreeMap null в качестве ключа")
    void nullableKeyComparator1() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(new NullableKeyComparator<>());

        // when
        tree.put(null, "test");

        // then
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName("Добавление в TreeMap null в качестве ключа")
    void nullableKeyComparator2() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(new NullableKeyComparator<>());

        // when
        tree.put(null, "test");
        tree.put("key", "test");

        // then
        assertThat(tree.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Добавление в TreeMap null в качестве ключа")
    void nullableKeyComparator3() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(new NullableKeyComparator<>());

        // when
        tree.put(null, "test");
        tree.put("key", "value");

        // then
        assertThat(tree.containsValue("test")).isTrue();
    }
}
