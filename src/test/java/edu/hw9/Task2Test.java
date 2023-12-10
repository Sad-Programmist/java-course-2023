package edu.hw9;

import edu.hw9.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Поиск в директории с пустым именем")
    void findDirectory1() {
        //given
        String directory = "";

        // when
        String result = Task2.runTask21(directory);

        // then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Поиск в директории с null")
    void findDirectory2() {
        //given
        String directory = null;

        // when
        String result = Task2.runTask21(directory);

        // then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Поиск в директории test")
    void findDirectory3() {
        //given
        String directory = "src/test/java/edu/hw9/resourses";

        // when
        String result = Task2.runTask21(directory);

        // then
        assertThat(result).isEqualTo("There is no directories that contains more than 1000 files");
    }

    @Test
    @DisplayName("Поиск файла в директории с пустым именем")
    void findFile1() {
        //given
        String directory = "";
        int fileSize = 0;
        String extension = null;

        // when
        String result = Task2.runTask22(directory, fileSize, extension);

        // then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Поиск файла в директории с null")
    void findFile2() {
        //given
        String directory = null;
        int fileSize = 0;
        String extension = null;

        // when
        String result = Task2.runTask22(directory, fileSize, extension);

        // then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Поиск файла в директории test с размером 0 и пустым расширением файла")
    void findFile3() {
        //given
        String directory = "test";
        int fileSize = 0;
        String extension = "";

        // when
        String result = Task2.runTask22(directory, fileSize, extension);

        // then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Поиск файла в директории test с размером 0 и null расширением файла")
    void findFile4() {
        //given
        String directory = "test";
        int fileSize = 0;
        String extension = null;

        // when
        String result = Task2.runTask22(directory, fileSize, extension);

        // then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Поиск файла в директории test с размером 0 и .txt расширением файла")
    void findFile5() {
        //given
        String directory = "src/test/java/edu/hw9/resourses";
        int fileSize = 0;
        String extension = ".txt";

        // when
        String result = Task2.runTask22(directory, fileSize, extension);

        // then
        assertThat(result).isEqualTo(
            "Files with size more than 0B and extension .txt: [src/test/java/edu/hw9/resourses/test1.txt]");
    }
}
