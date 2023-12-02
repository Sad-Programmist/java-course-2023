package edu.hw6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    private static final Path tempDir = Path.of("./src/test/res/hw6");

    private static Path existingFilePath;
    private static Path nonExistingFilePath;

    @BeforeAll
    static void setUpForAll() throws IOException {
        Files.walk(tempDir)
            .map(Path::toFile)
            .forEach(File::delete);
        if (!Files.exists(tempDir)) {
            Files.createDirectory(tempDir);
        }
        existingFilePath = Files.createFile(tempDir.resolve("testFile.txt"));
        nonExistingFilePath = tempDir.resolve("nonExistingFile.txt");
    }

    @Test
    @DisplayName("Успешное копирование файла, который существует")
    void cloneFile1() {
        // when
        Task2.runTask2(existingFilePath);

        // then
        assertTrue(Files.exists(tempDir.resolve("testFile — копия.txt")));
    }

    @Test
    @DisplayName("Ошибка при копировании файла, который не существует")
    void cloneFile2() {
        // when
        Task2.runTask2(nonExistingFilePath);

        // then
        assertFalse(Files.exists(tempDir.resolve("nonExistingFile — копия.txt")));
    }

    @Test
    @DisplayName("Успешное создание 2 копий файла, который существует")
    void cloneFile3() {
        // when
        Task2.runTask2(existingFilePath);
        Task2.runTask2(existingFilePath);

        // then
        assertTrue(Files.exists(tempDir.resolve("testFile — копия (2).txt")));
    }

    @Test
    @DisplayName("Успешное создание 3 копий файла, который существует")
    void cloneFile4() {
        // when
        Task2.runTask2(existingFilePath);
        Task2.runTask2(existingFilePath);
        Task2.runTask2(existingFilePath);

        // then
        assertTrue(Files.exists(tempDir.resolve("testFile — копия (3).txt")));
    }

    @Test
    @DisplayName("Ошибка при создании 2 копий файла, который не существует")
    void cloneFile5() {
        // when
        Task2.runTask2(nonExistingFilePath);
        Task2.runTask2(nonExistingFilePath);

        // then
        assertFalse(Files.exists(tempDir.resolve("nonExistingFile — копия (2).txt")));
    }

    @Test
    @DisplayName("Ошибка при создании 3 копий файла, который не существует")
    void cloneFile6() {
        // when
        Task2.runTask2(nonExistingFilePath);
        Task2.runTask2(nonExistingFilePath);
        Task2.runTask2(nonExistingFilePath);

        // then
        assertFalse(Files.exists(tempDir.resolve("nonExistingFile — копия (3).txt")));
    }
}
