package edu.hw3;

import edu.hw3.task5.Task5;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Сортировка списка полных имен по возрастанию")
    void parseContacts1() {
        // given
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String order = "ASC";

        // when
        List<Task5.Contact> sortedContacts = Task5.runTask5(names, order);

        // then
        assertThat(sortedContacts.toString())
            .isEqualTo("[Thomas Aquinas, Rene Descartes, David Hume, John Locke]");
    }

    @Test
    @DisplayName("Сортировка списка полных имен по убыванию")
    void parseContacts2() {
        // given
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String order = "DESC";

        // when
        List<Task5.Contact> sortedContacts = Task5.runTask5(names, order);

        // then
        assertThat(sortedContacts.toString())
            .isEqualTo("[Carl Gauss, Leonhard Euler, Paul Erdos]");
    }

    @Test
    @DisplayName("Сортировка списка, в котором у некоторых элементов нет фамилии, по убыванию")
    void parseContacts3() {
        // given
        String[] names = {"Paul", "Leonhard Euler", "Carl Gauss"};
        String order = "DESC";

        // when
        List<Task5.Contact> sortedContacts = Task5.runTask5(names, order);

        // then
        assertThat(sortedContacts.toString())
            .isEqualTo("[Paul , Carl Gauss, Leonhard Euler]");
    }

    @Test
    @DisplayName("Сортировка пустого списка по убыванию")
    void parseContacts4() {
        // given
        String[] names = {};
        String order = "DESC";

        // when
        List<Task5.Contact> sortedContacts = Task5.runTask5(names, order);

        // then
        assertThat(sortedContacts.toString())
            .isEqualTo("[]");
    }

    @Test
    @DisplayName("Сортировка списка, равного null, по убыванию")
    void parseContacts5() {
        // given
        String[] names = null;
        String order = "DESC";

        // when
        List<Task5.Contact> sortedContacts = Task5.runTask5(names, order);

        // then
        assertThat(sortedContacts.toString())
            .isEqualTo("[]");
    }

    @Test
    @DisplayName("Сортировка списка, в котором некоторые элементы равны null, по возрастанию")
    void parseContacts6() {
        // given
        String[] names = {"John Locke", null, "David Hume", "Rene Descartes"};
        String order = "ASC";

        // when
        List<Task5.Contact> sortedContacts = Task5.runTask5(names, order);

        // then
        assertThat(sortedContacts.toString())
            .isEqualTo("[Rene Descartes, David Hume, John Locke]");
    }
}
