package edu.hw6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static edu.hw6.task3.AbstractFilter.*;
import static edu.hw6.task3.FilterAttributes.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    private static final Path tempDir = Path.of("./src/test/res/hw6");

    @BeforeAll
    static void setUpForAll() throws IOException {
        Files.walk(tempDir)
            .map(Path::toFile)
            .forEach(File::delete);
        if (!Files.exists(tempDir)) {
            Files.createDirectory(tempDir);
        }
        Files.createFile(tempDir.resolve("testTXT.txt"));
        Files.createFile(tempDir.resolve("15_11_23.txt"));
        Files.createFile(tempDir.resolve("testPNG.png"));
        Files.createFile(tempDir.resolve("18_11_23.PNG"));
        Files.createFile(tempDir.resolve("testJPEG1.JPEG"));
        Files.createFile(tempDir.resolve("testJPEG2.jpeg"));
        Files.createFile(tempDir.resolve("testJpeg3.JPEG"));
        Files.createDirectory(tempDir.resolve("testDir1"));
        Files.createDirectory(tempDir.resolve("testDir2"));
    }

    @Test
    @DisplayName("Получение списка директорий")
    void abstractFilter1() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = DIRECTORY;

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\testDir1"),
            Paths.get(tempDir + "\\testDir2")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка файлов")
    void abstractFilter2() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE;

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt"),
            Paths.get(tempDir + "\\18_11_23.PNG"),
            Paths.get(tempDir + "\\testJPEG1.JPEG"),
            Paths.get(tempDir + "\\testJPEG2.jpeg"),
            Paths.get(tempDir + "\\testJpeg3.JPEG"),
            Paths.get(tempDir + "\\testPNG.png"),
            Paths.get(tempDir + "\\testTXT.txt")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка файлов с расширением *.png")
    void abstractFilter3() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(globMatches("*.png"));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\18_11_23.PNG"),
            Paths.get(tempDir + "\\testPNG.png")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка файлов с расширением, отличным от *.png")
    void abstractFilter4() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(not(globMatches("*.png")));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt"),
            Paths.get(tempDir + "\\testJPEG1.JPEG"),
            Paths.get(tempDir + "\\testJPEG2.jpeg"),
            Paths.get(tempDir + "\\testJpeg3.JPEG"),
            Paths.get(tempDir + "\\testTXT.txt")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка файлов с датой в названии")
    void abstractFilter5() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(regexContains("\\d{2}_d{2}_d{2}"));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt"),
            Paths.get(tempDir + "\\18_11_23.PNG")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка txt файлов с датой в названии")
    void abstractFilter6() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(regexMatches("\\d{2}_d{2}_d{2}.txt"));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка png файлов с датой в названии")
    void abstractFilter7() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(regexMatches("\\d{2}_d{2}_d{2}"))
            .and(globMatches("*.png"));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\18_11_23.PNG")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка файлов, доступных для чтения, с размером 0")
    void abstractFilter8() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = READABLE
            .and(sizeEquals(0));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt"),
            Paths.get(tempDir + "\\18_11_23.PNG"),
            Paths.get(tempDir + "\\testDir1"),
            Paths.get(tempDir + "\\testDir2"),
            Paths.get(tempDir + "\\testJPEG1.JPEG"),
            Paths.get(tempDir + "\\testJPEG2.jpeg"),
            Paths.get(tempDir + "\\testJpeg3.JPEG"),
            Paths.get(tempDir + "\\testPNG.png"),
            Paths.get(tempDir + "\\testTXT.txt")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка файлов, доступных для чтения, с размером больше 10 000")
    void abstractFilter9() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = READABLE
            .and(largerThan(10_000));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {};

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка обычных файлов, доступных для чтения, с размером меньше 10 000")
    void abstractFilter10() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(smallerThan(10_000));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt"),
            Paths.get(tempDir + "\\18_11_23.PNG"),
            Paths.get(tempDir + "\\testJPEG1.JPEG"),
            Paths.get(tempDir + "\\testJPEG2.jpeg"),
            Paths.get(tempDir + "\\testJpeg3.JPEG"),
            Paths.get(tempDir + "\\testPNG.png"),
            Paths.get(tempDir + "\\testTXT.txt")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка обычных файлов, доступных для чтения, с размером равным или меньше 1")
    void abstractFilter11() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(equalsOrSmallerThan(1));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {
            Paths.get(tempDir + "\\15_11_23.txt"),
            Paths.get(tempDir + "\\18_11_23.PNG"),
            Paths.get(tempDir + "\\testJPEG1.JPEG"),
            Paths.get(tempDir + "\\testJPEG2.jpeg"),
            Paths.get(tempDir + "\\testJpeg3.JPEG"),
            Paths.get(tempDir + "\\testPNG.png"),
            Paths.get(tempDir + "\\testTXT.txt")
        };

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

    @Test
    @DisplayName("Получение списка обычных файлов, доступных для чтения, с размером равным или больше 1")
    void abstractFilter12() throws IOException {
        // given
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(equalsOrLargerThan(1));

        // when
        DirectoryStream<Path> result = Files.newDirectoryStream(tempDir, filter);

        // then
        Path[] expected = {};

        int[] count = {0};
        result.forEach(path -> {
            assertThat(path).isEqualTo(expected[count[0]]);
            count[0]++;
        });
    }

}
