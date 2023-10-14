package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Может ли массив [1, 2, 3, 4] быть вложен в [0, 6]")
    void isNestable1() {
        // given
        int[] array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {0, 6};

        // when
        boolean isNestable = Task3.runTask3(array1, array2);

        // then
        assertThat(isNestable)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Может ли массив [3, 1] быть вложен в [4, 0]")
    void isNestable2() {
        // given
        int[] array1 = new int[] {3, 1};
        int[] array2 = new int[] {4, 0};

        // when
        boolean isNestable = Task3.runTask3(array1, array2);

        // then
        assertThat(isNestable)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Может ли массив [9, 9, 8] быть вложен в [8, 9]")
    void isNestable3() {
        // given
        int[] array1 = new int[] {9, 9, 8};
        int[] array2 = new int[] {8, 9};

        // when
        boolean isNestable = Task3.runTask3(array1, array2);

        // then
        assertThat(isNestable)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Может ли массив [1, 2, 3, 4] быть вложен в [2, 3]")
    void isNestable4() {
        // given
        int[] array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {2, 3};

        // when
        boolean isNestable = Task3.runTask3(array1, array2);

        // then
        assertThat(isNestable)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Может ли массив [] быть вложен в [2, 3]")
    void isNestable5() {
        // given
        int[] array1 = new int[] {};
        int[] array2 = new int[] {2, 3};

        // when
        boolean isNestable = Task3.runTask3(array1, array2);

        // then
        assertThat(isNestable)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Может ли массив null быть вложен в [2, 3]")
    void isNestable6() {
        // given
        int[] array1 = null;
        int[] array2 = new int[] {2, 3};

        // when
        boolean isNestable = Task3.runTask3(array1, array2);

        // then
        assertThat(isNestable)
            .isEqualTo(false);
    }
}

