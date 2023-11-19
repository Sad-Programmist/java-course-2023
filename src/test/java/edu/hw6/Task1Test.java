package edu.hw6;

import edu.hw6.task1.DiskMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    private static final Path tempDir = Path.of("./src/test/res/hw6");

    @BeforeEach
    void clearDir() throws IOException {
        Files.walk(tempDir)
            .map(Path::toFile)
            .forEach(File::delete);
        Files.createDirectory(tempDir);
    }

    @Test
    @DisplayName("Создание файла, в который добавляются 2 пары ключ:значение")
    void diskMapPut() throws FileNotFoundException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int[] stringIndex = {0};
        String[] strings = {
            "key1:value1",
            "key2:value2"
        };
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            assertThat(result).isEqualTo(strings[stringIndex[0]]);
            stringIndex[0]++;
        }
        scanner.close();
    }

    @Test
    @DisplayName("Создание файла, в который добавляются 2 пары ключ:значение, а затем одна удаляется")
    void diskMapRemove() throws FileNotFoundException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.remove("key1");

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int[] stringIndex = {0};
        String[] strings = {
            "key2:value2"
        };
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            assertThat(result).isEqualTo(strings[stringIndex[0]]);
            stringIndex[0]++;
        }
        scanner.close();
    }

    @Test
    @DisplayName("Создание файла, в который добавляются все пары ключ:значение из словаря")
    void diskMapPutAll() throws FileNotFoundException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        Map<String, String> map = Map.of(
            "key1", "value1",
            "key2", "value2",
            "key3", "value3"
        );
        diskMap.putAll(map);

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int[] stringIndex = {0};
        String[] strings = {
            "key1:value1",
            "key2:value2",
            "key3:value3"
        };
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            assertThat(result).isEqualTo(strings[stringIndex[0]]);
            stringIndex[0]++;
        }
        scanner.close();
    }

    @Test
    @DisplayName("Создание файла, в который добавляются 3 пары ключ:значение, а затем все удаляются")
    void diskMapClear() throws FileNotFoundException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        Map<String, String> map = Map.of(
            "key1", "value1",
            "key2", "value2",
            "key3", "value3"
        );
        diskMap.putAll(map);
        diskMap.clear();

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int[] stringIndex = {0};
        String[] strings = {};
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            assertThat(result).isEqualTo(strings[stringIndex[0]]);
            stringIndex[0]++;
        }
        scanner.close();
    }

    @Test
    @DisplayName("Случай, когда файл уже существует и имеет записи")
    void diskMapExistingFile() throws IOException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap1 = new DiskMap(filePath);
        diskMap1.put("key1", "value1");
        diskMap1.put("key2", "value2");
        DiskMap diskMap2 = new DiskMap(filePath);
        diskMap2.put("key3", "value3");
        diskMap2.put("key4", "value4");

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int[] stringIndex = {0};
        String[] strings = {
            "key1:value1",
            "key2:value2",
            "key3:value3",
            "key4:value4"
        };
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            assertThat(result).isEqualTo(strings[stringIndex[0]]);
            stringIndex[0]++;
        }
        scanner.close();
    }

    @Test
    @DisplayName("Проверка размера DiskMap, в который добавляются 2 пары ключ:значение")
    void diskMapSize() throws FileNotFoundException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int linesCount = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            linesCount++;
        }
        scanner.close();

        assertThat(linesCount).isEqualTo(diskMap.size());
    }

    @Test
    @DisplayName("Проверка на пустоту DiskMap, в который добавляются 2 пары ключ:значение")
    void diskMapIsEmpty() throws FileNotFoundException {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        // then
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int linesCount = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            linesCount++;
        }
        scanner.close();

        assertThat(linesCount == 0).isEqualTo(diskMap.isEmpty());
    }

    @Test
    @DisplayName("Проверка на наличие ключа в DiskMap, в который добавляются 2 пары ключ:значение")
    void diskMapContainsKey() {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        // then
        assertThat(diskMap.containsKey("key1")).isTrue();
    }

    @Test
    @DisplayName("Проверка на наличие значения в DiskMap, в который добавляются 2 пары ключ:значение")
    void diskMapContainsValue() {
        // given
        String filePath = tempDir + "\\diskmap.txt";

        // when
        DiskMap diskMap = new DiskMap(filePath);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        // then
        assertThat(diskMap.containsValue("value3")).isFalse();
    }
}
