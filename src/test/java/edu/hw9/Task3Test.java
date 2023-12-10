package edu.hw9;

import edu.hw9.task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Поиск файла в директории с пустым именем")
    void findFile1() {
        //given
        String directory = "";
        String filename = null;

        // when
        List<File> result = Task3.runTask3(directory, filename);

        // then
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Поиск файла в директории с null именем")
    void findFile2() {
        //given
        String directory = null;
        String filename = null;

        // when
        List<File> result = Task3.runTask3(directory, filename);

        // then
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Поиск файла в директории test и пустым именем файла")
    void findFile3() {
        //given
        String directory = "test";
        String filename = "";

        // when
        List<File> result = Task3.runTask3(directory, filename);

        // then
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Поиск файла в директории test и null именем файла")
    void findFile4() {
        //given
        String directory = "test";
        String filename = null;

        // when
        List<File> result = Task3.runTask3(directory, filename);

        // then
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Поиск файла в директории test и test1.txt именем файла")
    void findFile5() {
        //given
        String directory = "src/test/";
        String filename = "test1.txt";

        // when
        List<File> result = Task3.runTask3(directory, filename);

        // then
        assertThat(result).isEqualTo(List.of(new File("src/test/java/edu/hw9/resourses/test1.txt")));
    }
}
