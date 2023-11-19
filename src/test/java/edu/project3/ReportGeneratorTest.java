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
                """
                    #### Общая информация

                    |        Метрика        |     Значение |
                    |:---------------------:|-------------:|
                    |       Файл(-ы)        | `empty.txt, test1.txt, test2.txt` |
                    |    Начальная дата     |  2023-05-14 |
                    |     Конечная дата     |  2023-05-19 |
                    |  Количество запросов  |  3 |
                    | Средний размер ответа |  135b |

                    #### Запрашиваемые ресурсы

                    |     Ресурс      | Количество |
                    |:---------------:|-----------:|
                    | `product_1` | 3 |

                    #### Коды ответа

                    | Код |          Имя          | Количество |
                    |:---:|:---------------------:|-----------:|
                    | 200 | OK | 3 |

                    #### Типы запросов

                    |  Тип запроса   | Количество |
                    |:--------------:|-----------:|
                    | GET | 3 |

                    #### Размеры ответов

                    |  Размер ответа   | Количество |
                    |:----------------:|-----------:|
                    | 0 | 1 |
                    | 0<...<1000 | 2 |
                    | 1000<...<10000 | 0 |
                    | >10000 | 0 |
                    """
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
                """
                    ==== Общая информация

                    [cols="1,1"]
                    |===
                    | Метрика | Значение
                    | Файл(-ы) | `empty.txt, test1.txt, test2.txt`
                    | Начальная дата | 2023-05-14
                    | Конечная дата | 2023-05-19
                    | Количество запросов | 3
                    | Средний размер ответа | 135b

                    |===
                    ==== Запрашиваемые ресурсы

                    [cols="1,1"]
                    |===
                    | Ресурс | Количество\s
                    | `product_1` | 3
                    |===

                    ==== Коды ответа

                    [cols="1,1,1"]
                    |===
                    | Код | Имя | Количество\s
                    | 200 | OK | 3
                    |===

                    ==== Типы запросов

                    [cols="1,1"]
                    |===
                    |  Тип запроса   | Количество
                    | GET | 3
                    |===

                    ==== Размеры ответов

                    [cols="1,1"]
                    |===
                    |  Размер ответа   | Количество\s
                    | 0 | 1
                    | 0<...<1000 | 2
                    | 1000<...<10000 | 0
                    | >10000 | 0
                    |===
                    """
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
                """
                    Общая информация
                            Метрика        |       Значение    \s
                    -----------------------|-------------------
                           Файл(-ы)        | `empty.txt, test1.txt, test2.txt`
                        Начальная дата     |  2023-05-14
                         Конечная дата     |  2023-05-19
                      Количество запросов  |  3
                     Средний размер ответа |  135b

                    Запрашиваемые ресурсы
                                  Ресурс              | Количество\s
                    ----------------------------------|------------
                    `product_1`                       | 3

                    Коды ответа
                     Код |                     Имя                      | Количество\s
                    -----|----------------------------------------------|------------
                     200 | OK                                           | 3

                    Типы запросов
                          Тип       | Количество\s
                    ----------------|------------
                     GET            | 3

                    Размеры ответов
                      Размер ответа   | Количество\s
                    ------------------|------------
                             0        | 1
                         0<...<1000   | 2
                      1000<...<10000  | 0
                          >10000      | 0
                    """);
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

