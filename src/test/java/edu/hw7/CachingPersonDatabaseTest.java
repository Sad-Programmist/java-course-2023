package edu.hw7;

import edu.hw7.task3.CachingPersonDatabase;
import edu.hw7.task3.Person;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CachingPersonDatabaseTest {

    @Test
    @DisplayName("Параллельное добавление и поиск по имени")
    void parallelAddAndFindByName() throws InterruptedException {
        // given
        CachingPersonDatabase database = new CachingPersonDatabase();
        List<Thread> threads = new ArrayList<>();
        Person john = new Person(1, "John", "123 Main St", "123-456-7890");
        Person jane = new Person(2, "Jane", "456 Oak St", "987-654-3210");
        Person bob = new Person(3, "Bob", "789 Pine St", "111-222-3333");

        // when
        threads.add(new Thread(() -> database.add(john)));
        threads.add(new Thread(() -> database.add(jane)));
        threads.add(new Thread(() -> database.add(bob)));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        // then
        List<Person> result = database.findByName("John");
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(john);
    }

    @Test
    @DisplayName("Параллельное добавление и поиск по адресу")
    void parallelAddAndFindByAddress() throws InterruptedException {
        // given
        CachingPersonDatabase database = new CachingPersonDatabase();
        List<Thread> threads = new ArrayList<>();
        Person john = new Person(1, "John", "123 Main St", "123-456-7890");
        Person jane = new Person(2, "Jane", "456 Oak St", "987-654-3210");
        Person bob = new Person(3, "Bob", "789 Pine St", "111-222-3333");

        // when
        threads.add(new Thread(() -> database.add(john)));
        threads.add(new Thread(() -> database.add(jane)));
        threads.add(new Thread(() -> database.add(bob)));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        // then
        List<Person> result = database.findByAddress("456 Oak St");
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(jane);
    }

    @Test
    @DisplayName("Параллельное добавление и поиск по телефону")
    void parallelAddAndFindByPhone() throws InterruptedException {
        // given
        CachingPersonDatabase database = new CachingPersonDatabase();
        List<Thread> threads = new ArrayList<>();
        Person john = new Person(1, "John", "123 Main St", "123-456-7890");
        Person jane = new Person(2, "Jane", "456 Oak St", "987-654-3210");
        Person bob = new Person(3, "Bob", "789 Pine St", "111-222-3333");

        // when
        threads.add(new Thread(() -> database.add(john)));
        threads.add(new Thread(() -> database.add(jane)));
        threads.add(new Thread(() -> database.add(bob)));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        // then
        List<Person> result = database.findByPhone("111-222-3333");
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(bob);
    }

    @Test
    @DisplayName("Параллельное добавление объектов с null полями и поиск по имени")
    void parallelAddWithNull() throws InterruptedException {
        // given
        CachingPersonDatabase database = new CachingPersonDatabase();
        List<Thread> threads = new ArrayList<>();
        Person john = new Person(1, null, "123 Main St", "123-456-7890");
        Person jane = new Person(2, "Jane", null, "987-654-3210");
        Person bob = new Person(3, "Bob", "789 Pine St", null);

        // when
        threads.add(new Thread(() -> database.add(john)));
        threads.add(new Thread(() -> database.add(jane)));
        threads.add(new Thread(() -> database.add(bob)));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        // then
        List<Person> result = database.findByName("Bob");
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Параллельное добавление, удаление и поиск по имени")
    void parallelAddAndDeleteByName() throws InterruptedException {
        // given
        CachingPersonDatabase database = new CachingPersonDatabase();
        List<Thread> threads = new ArrayList<>();
        Person john = new Person(1, "John", "123 Main St", "123-456-7890");
        Person jane = new Person(2, "Jane", "456 Oak St", "987-654-3210");
        Person bob = new Person(3, "Bob", "789 Pine St", "111-222-3333");

        // when
        threads.add(new Thread(() -> database.add(john)));
        threads.add(new Thread(() -> database.add(jane)));
        threads.add(new Thread(() -> database.add(bob)));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        threads.clear();

        threads.add(new Thread(() -> database.delete(1)));
        threads.add(new Thread(() -> database.delete(2)));
        threads.add(new Thread(() -> database.delete(3)));
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        // then
        List<Person> result = database.findByName("John");
        assertThat(result).isEmpty();
    }
}
