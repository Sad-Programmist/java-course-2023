package edu.project3;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReportGeneratorTest {

    private static final List<String> files = List.of("empty.txt", "test1.txt", "test2.txt");
    private static final OffsetDateTime fromDate = OffsetDateTime.of(2023, 5, 14, 0, 0, 0, 0, ZoneOffset.UTC);
    private static final OffsetDateTime toDate = OffsetDateTime.of(2023, 5, 19, 0, 0, 0, 0, ZoneOffset.UTC);
    private static final int requestNumber = 3;
    private static final long meanBodyBytesSent = 135;
    private static final Map<String, Integer> sourceStatistic = Map.of(
        "product_1", 3
    );
    private static final Map<Integer, Integer> statusStatistic = Map.of(
        200, 3
    );
    private static final Map<String, Integer> requestTypeStatistic = Map.of(
        "GET", 3
    );
    private static final Map<String, Integer> bodyBytesSentStatistic = Map.of(
        "0", 1,
        "1000<...<10000", 0,
        "0<...<1000", 2,
        ">10000", 0
    );

    private static final LogStatistic logStatistic = new LogStatistic(
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

    @Test
    @DisplayName("Вывод в формате markdown")
    void generateMarkdownReport1() {
        // given
        String format = "markdown";

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo(
                "#### Общая информация\n" +
                    "\n" +
                    "|        Метрика        |     Значение |\n" +
                    "|:---------------------:|-------------:|\n" +
                    "|       Файл(-ы)        | `empty.txt, test1.txt, test2.txt` |\n" +
                    "|    Начальная дата     |  2023-05-14 |\n" +
                    "|     Конечная дата     |  2023-05-19 |\n" +
                    "|  Количество запросов  |  3 |\n" +
                    "| Средний размер ответа |  135b |\n" +
                    "\n" +
                    "#### Запрашиваемые ресурсы\n" +
                    "\n" +
                    "|     Ресурс      | Количество |\n" +
                    "|:---------------:|-----------:|\n" +
                    "| `product_1` | 3 |\n" +
                    "\n" +
                    "#### Коды ответа\n" +
                    "\n" +
                    "| Код |          Имя          | Количество |\n" +
                    "|:---:|:---------------------:|-----------:|\n" +
                    "| 200 | OK | 3 |\n" +
                    "\n" +
                    "#### Типы запросов\n" +
                    "\n" +
                    "|  Тип запроса   | Количество |\n" +
                    "|:--------------:|-----------:|\n" +
                    "| GET | 3 |\n" +
                    "\n" +
                    "#### Размеры ответов\n" +
                    "\n" +
                    "|  Размер ответа   | Количество |\n" +
                    "|:----------------:|-----------:|\n" +
                    "| 0 | 1 |\n" +
                    "| 0<...<1000 | 2 |\n" +
                    "| 1000<...<10000 | 0 |\n" +
                    "| >10000 | 0 |\n"
            );
    }

    @Test
    @DisplayName("Вывод в формате markdown, если статиcтика null")
    void generateMarkdownReport2() {
        // given
        LogStatistic logStatistic = null;
        String format = "markdown";

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Вывод в формате adoc")
    void generateAdocReport1() {
        // given
        String format = "adoc";

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo(
                "==== Общая информация\n" +
                    "\n" +
                    "[cols=\"1,1\"]\n" +
                    "|===\n" +
                    "| Метрика | Значение\n" +
                    "| Файл(-ы) | `empty.txt, test1.txt, test2.txt`\n" +
                    "| Начальная дата | 2023-05-14\n" +
                    "| Конечная дата | 2023-05-19\n" +
                    "| Количество запросов | 3\n" +
                    "| Средний размер ответа | 135b\n" +
                    "\n" +
                    "|===\n" +
                    "==== Запрашиваемые ресурсы\n" +
                    "\n" +
                    "[cols=\"1,1\"]\n" +
                    "|===\n" +
                    "| Ресурс | Количество \n" +
                    "| `product_1` | 3\n" +
                    "|===\n" +
                    "\n" +
                    "==== Коды ответа\n" +
                    "\n" +
                    "[cols=\"1,1,1\"]\n" +
                    "|===\n" +
                    "| Код | Имя | Количество \n" +
                    "| 200 | OK | 3\n" +
                    "|===\n" +
                    "\n" +
                    "==== Типы запросов\n" +
                    "\n" +
                    "[cols=\"1,1\"]\n" +
                    "|===\n" +
                    "|  Тип запроса   | Количество\n" +
                    "| GET | 3\n" +
                    "|===\n" +
                    "\n" +
                    "==== Размеры ответов\n" +
                    "\n" +
                    "[cols=\"1,1\"]\n" +
                    "|===\n" +
                    "|  Размер ответа   | Количество \n" +
                    "| 0 | 1\n" +
                    "| 0<...<1000 | 2\n" +
                    "| 1000<...<10000 | 0\n" +
                    "| >10000 | 0\n" +
                    "|===\n"
            );
    }

    @Test
    @DisplayName("Вывод в формате adoc, если статиcтика null")
    void generateAdocReport2() {
        // given
        LogStatistic logStatistic = null;
        String format = "adoc";

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Вывод в консоль")
    void generateConsoleReport1() {
        // given
        String format = null;

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo(
                "Общая информация\n" +
                    "        Метрика        |       Значение     \n" +
                    "-----------------------|-------------------\n" +
                    "       Файл(-ы)        | `empty.txt, test1.txt, test2.txt`\n" +
                    "    Начальная дата     |  2023-05-14\n" +
                    "     Конечная дата     |  2023-05-19\n" +
                    "  Количество запросов  |  3\n" +
                    " Средний размер ответа |  135b\n" +
                    "\n" +
                    "Запрашиваемые ресурсы\n" +
                    "              Ресурс              | Количество \n" +
                    "----------------------------------|------------\n" +
                    "`product_1`                       | 3\n" +
                    "\n" +
                    "Коды ответа\n" +
                    " Код |                     Имя                      | Количество \n" +
                    "-----|----------------------------------------------|------------\n" +
                    " 200 | OK                                           | 3\n" +
                    "\n" +
                    "Типы запросов\n" +
                    "      Тип       | Количество \n" +
                    "----------------|------------\n" +
                    " GET            | 3\n" +
                    "\n" +
                    "Размеры ответов\n" +
                    "  Размер ответа   | Количество \n" +
                    "------------------|------------\n" +
                    "         0        | 1\n" +
                    "     0<...<1000   | 2\n" +
                    "  1000<...<10000  | 0\n" +
                    "      >10000      | 0\n");
    }

    @Test
    @DisplayName("Вывод в консоль, если статиcтика null")
    void generateConsoleReport2() {
        // given
        LogStatistic logStatistic = null;
        String format = null;

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Вывод в консоль, если формат некорректный")
    void generateWrongFormatReport() {
        // given
        String format = "format";

        // when
        String result = ReportGenerator.generateReport(logStatistic, format);

        // then
        assertThat(result)
            .isEqualTo("");
    }
}

