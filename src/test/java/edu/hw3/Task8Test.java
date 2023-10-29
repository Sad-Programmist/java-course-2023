package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Расположение элементов списка в обратном порядке")
    void reverseOrder1() {
        // given
        List<Integer> originalList = List.of(1, 2, 3);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(originalList);

        // when
        List<Integer> reversedList = new ArrayList<>();
        while (backwardIterator.hasNext()) {
            reversedList.add(backwardIterator.next());
        }
        // then
        assertThat(reversedList)
            .isEqualTo(List.of(3, 2, 1));
    }

    @Test
    @DisplayName("Проверка наличия следующего элемента, когда он есть")
    void hasNext1() {
        // given
        List<Integer> originalList = List.of(1, 2, 3);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(originalList);

        // then
        assertThat(backwardIterator.hasNext())
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Проверка наличия следующего элемента, когда его нет")
    void hasNext2() {
        // given
        List<Integer> originalList = new ArrayList<>();
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(originalList);

        // then
        assertThat(backwardIterator.hasNext())
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Получение следующего элемента в списке 1 раз")
    void next1() {
        // given
        List<Integer> originalList = List.of(1, 2, 3);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(originalList);

        // then
        assertThat(backwardIterator.next())
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Получение следующего элемента в списке 2 раза")
    void next2() {
        // given
        List<Integer> originalList = List.of(1, 2, 3);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(originalList);

        // when
        backwardIterator.next();

        // then
        assertThat(backwardIterator.next())
            .isEqualTo(2);
    }
}
