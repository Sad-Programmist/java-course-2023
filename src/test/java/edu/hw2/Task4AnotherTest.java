package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.CallingInfoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4AnotherTest {

    @Test
    @DisplayName("Вызов функции из метода callingInfo1 класса edu.hw2.Task4AnotherTest")
    void callingInfo1() {
        // when
        CallingInfo callingInfo = CallingInfoUtil.callingInfo();

        // then
        assertThat(callingInfo)
            .isEqualTo(new CallingInfo("edu.hw2.Task4AnotherTest", "callingInfo1"));
    }

    @Test
    @DisplayName("Вызов функции из метода callingInfo2 класса edu.hw2.Task4AnotherTest")
    void callingInfo2() {
        // when
        CallingInfo callingInfo = CallingInfoUtil.callingInfo();

        // then
        assertThat(callingInfo)
            .isEqualTo(new CallingInfo("edu.hw2.Task4AnotherTest", "callingInfo2"));
    }
}
