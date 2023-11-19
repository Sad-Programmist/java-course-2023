package edu.hw6;

import edu.hw6.task6.Task6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Сканирование портов с 0 до 10000")
    public void scanPorts1() {
        //given
        PrintStream originalOut = System.out;

        try {
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            //when
            Task6.runTask6(0, 10000);

            //then
            assertThat(outputStreamCaptor.toString()).isNotEmpty();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("Сканирование портов с -1 до -10000")
    public void scanPorts2() {
        //given
        PrintStream originalOut = System.out;

        try {
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            //when
            Task6.runTask6(-1, -10000);

            //then
            assertThat(outputStreamCaptor.toString()).isEmpty();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("Сканирование портов с 0 до 15000")
    public void scanPorts3() {
        //given
        PrintStream originalOut = System.out;

        try {
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            //when
            Task6.runTask6(0, 15000);

            //then
            assertThat(outputStreamCaptor.toString()).isNotEmpty();
        } finally {
            System.setOut(originalOut);
        }
    }
}
