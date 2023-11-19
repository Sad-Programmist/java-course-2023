package edu.hw6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    private static final Path tempDir = Path.of("./src/test/res/hw6");

    @BeforeEach
    void clearDir() throws IOException {
        Files.walk(tempDir)
            .map(Path::toFile)
            .forEach(File::delete);
        Files.createDirectory(tempDir);
    }

    @Test
    @DisplayName("Успешное создание файла")
    void writeTextToFile1() throws FileNotFoundException {
        // given
        Path filePath = tempDir.resolve("testFile.txt");
        String text = "Hello, this is a test text.";

        // when
        Task4.runTask4(filePath.toString(), text);

        // then
        assertThat(Files.exists(filePath)).isTrue();
    }

    @Test
    @DisplayName("Успешная запись текста в файл, который  существует")
    void writeTextToFile2() throws IOException {
        // given
        Path filePath = tempDir.resolve("testFile.txt");
        String text = "Hello, this is a test text.";

        // when
        Task4.runTask4(filePath.toString(), text);

        // then
        File file = new File(filePath.toString());
        Scanner scanner = new Scanner(file);
        String result = scanner.nextLine();
        scanner.close();

        assertThat(result).isEqualTo(text);
    }

    @Test
    @DisplayName("Успешная запись текста в файл, который не существует")
    void writeTextToFile3() throws FileNotFoundException {
        // given
        Path filePath = tempDir.resolve("testFile.txt");
        String text = "Hello, this is a test text.";

        // when
        Task4.runTask4(filePath.toString(), text);

        // then
        File file = new File(filePath.toString());
        Scanner scanner = new Scanner(file);
        String result = scanner.nextLine();
        scanner.close();

        assertThat(result).isEqualTo(text);
    }
}
