package edu.hw10;

import edu.hw10.task1.MyClass;
import edu.hw10.task1.MyRecord;
import edu.hw10.task1.RandomObjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Генерация объекта класса без фабричного метода")
    void generatePojoWithoutFactoryMethod() throws Exception {
        // given
        RandomObjectGenerator rog = new RandomObjectGenerator();

        // when
        MyClass myClass = rog.nextObject(MyClass.class);

        // then
        assertThat(myClass).isNotNull();
    }

    @Test
    @DisplayName("Генерация объекта класса с фабричным методом")
    void generatePojoWithFactoryMethod() throws Exception {
        // given
        RandomObjectGenerator rog = new RandomObjectGenerator();

        // when
        MyClass myClass = rog.nextObject(MyClass.class, "create");

        // then
        assertThat(myClass).isNotNull();
    }

    @Test
    @DisplayName("Генерация объекта record класса")
    void generateRecord() throws Exception {
        // given
        RandomObjectGenerator rog = new RandomObjectGenerator();

        // when
        MyRecord myRecord = rog.nextObject(MyRecord.class);

        // then
        assertThat(myRecord).isNotNull();
    }
}
