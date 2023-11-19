package edu.project3;

import edu.project3.utils.DateParseUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogAnalyzerTest {

    @TempDir
    static Path tempDir;

    private static Path txt1;
    private static Path txt2;
    private static Path empty;

    @BeforeAll
    static void setUpForAll() throws IOException {
        txt1 = Files.createFile(tempDir.resolve("test1.txt"));
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempDir + "\\test1.txt"))) {
            writer1.write(
                "93.180.71.3 - - [14/May/2023:08:05:32 +0000] \"HEAD /downloads/product_2 HTTP/1.1\" 304 30 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"\n" +
                    "93.180.71.3 - - [17/May/2023:08:05:23 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 20 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"");
        }

        txt2 = Files.createFile(tempDir.resolve("test2.txt"));
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempDir + "\\test2.txt"))) {
            writer2.write(
                "80.91.33.133 - - [18/May/2023:08:05:24 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.17)\"\n" +
                    "217.168.17.5 - - [18/May/2023:08:05:34 +0000] \"GET /downloads/product_1 HTTP/1.1\" 200 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"");
        }

        empty = Files.createFile(tempDir.resolve("empty.txt"));
    }

    @Test
    @DisplayName("Анализ логов из файла test1.txt")
    void analyzeLogs1() {
        // given
        String path = txt1.toString();
        String from = "2023-05-15";
        String to = "2023-05-19";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        List<String> files = List.of(txt1.toString());
        OffsetDateTime fromDate = OffsetDateTime.of(2023, 5, 15, 0, 0, 0, 0, ZoneOffset.UTC);
        OffsetDateTime toDate = OffsetDateTime.of(2023, 5, 19, 0, 0, 0, 0, ZoneOffset.UTC);
        int requestNumber = 1;
        long meanBodyBytesSent = 20;
        Map<String, Integer> sourceStatistic = Map.of(
            "product_1", 1
        );
        Map<Integer, Integer> statusStatistic = Map.of(
            304, 1
        );
        Map<String, Integer> requestTypeStatistic = Map.of(
            "GET", 1
        );
        Map<String, Integer> bodyBytesSentStatistic = Map.of(
            "0", 0,
            "1000<...<10000", 0,
            "0<...<1000", 1,
            ">10000", 0
        );

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Анализ логов из файла test2.txt")
    void analyzeLogs2() {
        // given
        String path = txt2.toString();
        String from = "2023-05-15";
        String to = "2023-05-19";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        List<String> files = List.of(txt2.toString());
        OffsetDateTime fromDate = OffsetDateTime.of(2023, 5, 15, 0, 0, 0, 0, ZoneOffset.UTC);
        OffsetDateTime toDate = OffsetDateTime.of(2023, 5, 19, 0, 0, 0, 0, ZoneOffset.UTC);
        int requestNumber = 2;
        long meanBodyBytesSent = 245;
        Map<String, Integer> sourceStatistic = Map.of(
            "product_1", 2
        );
        Map<Integer, Integer> statusStatistic = Map.of(
            404, 1,
            200, 1
        );
        Map<String, Integer> requestTypeStatistic = Map.of(
            "GET", 2
        );
        Map<String, Integer> bodyBytesSentStatistic = Map.of(
            "0", 1,
            "1000<...<10000", 0,
            "0<...<1000", 1,
            ">10000", 0
        );

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Анализ логов из директории tempDir")
    void analyzeLogs3() {
        // given
        String path = tempDir + "\\*";
        String from = "2023-05-14";
        String to = "2023-05-19";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        List<String> files = List.of("empty.txt", "test1.txt", "test2.txt");
        OffsetDateTime fromDate = OffsetDateTime.of(2023, 5, 14, 0, 0, 0, 0, ZoneOffset.UTC);
        OffsetDateTime toDate = OffsetDateTime.of(2023, 5, 19, 0, 0, 0, 0, ZoneOffset.UTC);
        int requestNumber = 4;
        long meanBodyBytesSent = 135;
        Map<String, Integer> sourceStatistic = Map.of(
            "product_1", 3,
            "product_2", 1
        );
        Map<Integer, Integer> statusStatistic = Map.of(
            404, 1,
            200, 1,
            304, 2
        );
        Map<String, Integer> requestTypeStatistic = Map.of(
            "GET", 3,
            "HEAD", 1
        );
        Map<String, Integer> bodyBytesSentStatistic = Map.of(
            "0", 1,
            "1000<...<10000", 0,
            "0<...<1000", 3,
            ">10000", 0
        );

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Анализ логов из файла с путем null")
    void analyzeLogs4() {
        // given
        String path = null;
        String from = "2023-05-14";
        String to = "2023-05-19";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        assertThat(result)
            .isNull();
    }

    @Test
    @DisplayName("Анализ логов из файла empty.txt")
    void analyzeLogs5() {
        // given
        String path = empty.toString();
        String from = "2023-05-14";
        String to = "2023-05-19";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        assertThat(result)
            .isEqualTo(new LogStatistic(
                List.of(empty.toString()),
                DateParseUtils.fromISOtoODT(from),
                DateParseUtils.fromISOtoODT(to),
                0,
                0,
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap()
            ));
    }

    @Test
    @DisplayName("Анализ логов из директории tempDir, если даты равны null")
    void analyzeLogs6() {
        // given
        String path = tempDir + "\\*";
        String from = null;
        String to = null;

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        List<String> files = List.of("empty.txt", "test1.txt", "test2.txt");
        OffsetDateTime fromDate = null;
        OffsetDateTime toDate = null;
        int requestNumber = 4;
        long meanBodyBytesSent = 135;
        Map<String, Integer> sourceStatistic = Map.of(
            "product_1", 3,
            "product_2", 1
        );
        Map<Integer, Integer> statusStatistic = Map.of(
            404, 1,
            200, 1,
            304, 2
        );
        Map<String, Integer> requestTypeStatistic = Map.of(
            "GET", 3,
            "HEAD", 1
        );
        Map<String, Integer> bodyBytesSentStatistic = Map.of(
            "0", 1,
            "1000<...<10000", 0,
            "0<...<1000", 3,
            ">10000", 0
        );

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Анализ логов из директории tempDir, если начальная дата равна null")
    void analyzeLogs7() {
        // given
        String path = tempDir + "\\*";
        String from = null;
        String to = "2023-05-19";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        List<String> files = List.of("empty.txt", "test1.txt", "test2.txt");
        OffsetDateTime fromDate = null;
        OffsetDateTime toDate = OffsetDateTime.of(2023, 5, 19, 0, 0, 0, 0, ZoneOffset.UTC);
        int requestNumber = 4;
        long meanBodyBytesSent = 135;
        Map<String, Integer> sourceStatistic = Map.of(
            "product_1", 3,
            "product_2", 1
        );
        Map<Integer, Integer> statusStatistic = Map.of(
            404, 1,
            200, 1,
            304, 2
        );
        Map<String, Integer> requestTypeStatistic = Map.of(
            "GET", 3,
            "HEAD", 1
        );
        Map<String, Integer> bodyBytesSentStatistic = Map.of(
            "0", 1,
            "1000<...<10000", 0,
            "0<...<1000", 3,
            ">10000", 0
        );

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Анализ логов из директории tempDir, если конечная дата равна null")
    void analyzeLogs8() {
        // given
        String path = tempDir + "\\*";
        String from = "2023-05-14";
        String to = null;

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, to);

        // then
        List<String> files = List.of("empty.txt", "test1.txt", "test2.txt");
        OffsetDateTime fromDate = OffsetDateTime.of(2023, 5, 14, 0, 0, 0, 0, ZoneOffset.UTC);
        OffsetDateTime toDate = null;
        int requestNumber = 4;
        long meanBodyBytesSent = 135;
        Map<String, Integer> sourceStatistic = Map.of(
            "product_1", 3,
            "product_2", 1
        );
        Map<Integer, Integer> statusStatistic = Map.of(
            404, 1,
            200, 1,
            304, 2
        );
        Map<String, Integer> requestTypeStatistic = Map.of(
            "GET", 3,
            "HEAD", 1
        );
        Map<String, Integer> bodyBytesSentStatistic = Map.of(
            "0", 1,
            "1000<...<10000", 0,
            "0<...<1000", 3,
            ">10000", 0
        );

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Анализ логов из файла test1.txt")
    void analyzeLogs9() {
        // given
        String path = txt1.toString();
        String from = "2024-05-15";

        // when
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic result = logAnalyzer.analyzeLogs(path, from, null);

        // then
        List<String> files = List.of(txt1.toString());
        OffsetDateTime fromDate = OffsetDateTime.of(2024, 5, 15, 0, 0, 0, 0, ZoneOffset.UTC);
        int requestNumber = 0;
        long meanBodyBytesSent = 0;
        Map<String, Integer> sourceStatistic = Collections.emptyMap();
        Map<Integer, Integer> statusStatistic = Collections.emptyMap();
        Map<String, Integer> requestTypeStatistic = Collections.emptyMap();
        Map<String, Integer> bodyBytesSentStatistic = Collections.emptyMap();

        LogStatistic expected = new LogStatistic(
            files,
            fromDate,
            null,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );

        assertThat(result)
            .isEqualTo(expected);
    }
}
