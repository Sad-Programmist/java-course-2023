package edu.project3;

import edu.project3.utils.ReadUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReadUtilsTest {

    @TempDir
    static Path tempDir;

    private static Path txt1;
    private static Path txt2;

    @BeforeAll
    static void setUpForAll() throws IOException {
        txt1 = Files.createFile(tempDir.resolve("test1.txt"));
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempDir + "\\test1.txt"))) {
            writer1.write("line1");
            writer1.newLine();
            writer1.write("line2");
        }

        txt2 = Files.createFile(tempDir.resolve("test2.txt"));
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempDir + "\\test2.txt"))) {
            writer2.write("line3");
            writer2.newLine();
            writer2.write("line4");
        }
    }

    @Test
    @DisplayName("Чтение из файла test1.txt")
    void readFile1() {
        // given
        String path = txt1.toString();

        // when
        List<String> result = ReadUtils.readFile(path);

        // then
        assertThat(result)
            .isEqualTo(List.of("line1", "line2"));
    }

    @Test
    @DisplayName("Чтение из файла с путем null")
    void readFile2() {
        // given
        String path = null;

        // when
        List<String> result = ReadUtils.readFile(path);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Чтение из несуществующего файла")
    void readFile3() {
        // given
        String path = "txt.txt";

        // when
        List<String> result = ReadUtils.readFile(path);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Чтение из файлов в дирректории tempDir")
    void readMultipleFiles1() {
        // given
        String path = tempDir.toString();

        // when
        List<String> result = ReadUtils.readMultipleFiles(path);

        // then
        assertThat(result)
            .isEqualTo(List.of("line1", "line2", "line3", "line4"));
    }

    @Test
    @DisplayName("Чтение из файлов в дирректории с путем null")
    void readMultipleFiles2() {
        // given
        String path = null;

        // when
        List<String> result = ReadUtils.readMultipleFiles(path);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Чтение из файлов в несуществующей дирректории")
    void readMultipleFiles3() {
        // given
        String path = "dir";

        // when
        List<String> result = ReadUtils.readMultipleFiles(path);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Список файлов в дирректории tempDir")
    void getFiles1() {
        // given
        String path = tempDir.toString();

        // when
        List<File> result = ReadUtils.getFiles(path);

        // then
        assertThat(result)
            .isEqualTo(List.of(txt1.toFile(), txt2.toFile()));
    }

    @Test
    @DisplayName("Список файлов в дирректории с путем null")
    void getFiles2() {
        // given
        String path = null;

        // when
        List<File> result = ReadUtils.getFiles(path);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Список файлов в несуществующей дирректории")
    void getFiles3() {
        // given
        String path = "dir";

        // when
        List<File> result = ReadUtils.getFiles(path);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }
}
