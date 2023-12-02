package edu.project3;

import edu.project3.utils.DateParseUtils;
import java.util.Map;
import org.springframework.http.HttpStatus;

public class ReportGenerator {

    private ReportGenerator() {
    }

    public static String generateReport(LogStatistic logStatistic, String format) {
        if (logStatistic == null) {
            return "";
        }
        if (format == null) {
            return generateConsoleReport(logStatistic);
        }
        return switch (format) {
            case "markdown" -> generateMarkdownReport(logStatistic);
            case "adoc" -> generateAdocReport(logStatistic);
            default -> "";
        };
    }

    @SuppressWarnings("MultipleStringLiterals")
    private static String generateMarkdownReport(LogStatistic logStatistic) {
        StringBuilder report = new StringBuilder();

        String fromDate = DateParseUtils.fromODTtoISO(logStatistic.fromDate());
        String toDate = DateParseUtils.fromODTtoISO(logStatistic.toDate());

        report.append("#### Общая информация\n\n")
            .append("|        Метрика        |     Значение |\n")
            .append("|:---------------------:|-------------:|\n")
            .append("|       Файл(-ы)        | `").append(String.join(", ", logStatistic.files())).append("` |\n")
            .append("|    Начальная дата     |  ").append(logStatistic.fromDate() != null ? fromDate : "-")
            .append(" |\n")
            .append("|     Конечная дата     |  ").append(logStatistic.toDate() != null ? toDate : "-").append(" |\n")
            .append("|  Количество запросов  |  ").append(logStatistic.requestNumber()).append(" |\n")
            .append("| Средний размер ответа |  ").append(logStatistic.meanBodyBytesSent()).append("b |\n\n");

        report.append("#### Запрашиваемые ресурсы\n\n")
            .append("|     Ресурс      | Количество |\n")
            .append("|:---------------:|-----------:|\n");

        for (Map.Entry<String, Integer> entry : logStatistic.sourceStatistic().entrySet()) {
            report.append("| `").append(entry.getKey()).append("` | ").append(entry.getValue()).append(" |\n");
        }

        report.append("\n#### Коды ответа\n\n")
            .append("| Код |          Имя          | Количество |\n")
            .append("|:---:|:---------------------:|-----------:|\n");

        for (Map.Entry<Integer, Integer> entry : logStatistic.statusStatistic().entrySet()) {
            String httpStatus = HttpStatus.valueOf(entry.getKey()).getReasonPhrase();
            report.append("| ").append(entry.getKey()).append(" | ").append(httpStatus).append(" | ")
                .append(entry.getValue()).append(" |\n");
        }

        report.append("\n#### Типы запросов\n\n")
            .append("|  Тип запроса   | Количество |\n")
            .append("|:--------------:|-----------:|\n");

        for (Map.Entry<String, Integer> entry : logStatistic.requestTypeStatistic().entrySet()) {
            report.append("| ").append(entry.getKey()).append(" | ").append(entry.getValue()).append(" |\n");
        }

        report.append("\n#### Размеры ответов\n\n")
            .append("|  Размер ответа   | Количество |\n")
            .append("|:----------------:|-----------:|\n");

        report.append("| 0 | ").append(logStatistic.bodyBytesSentStatistic().get("0"))
            .append(" |\n");
        report.append("| 0<...<1000 | ")
            .append(logStatistic.bodyBytesSentStatistic().get("0<...<1000"))
            .append(" |\n");
        report.append("| 1000<...<10000 | ")
            .append(logStatistic.bodyBytesSentStatistic().get("1000<...<10000"))
            .append(" |\n");
        report.append("| >10000 | ").append(logStatistic.bodyBytesSentStatistic().get(">10000"))
            .append(" |\n");

        return report.toString();
    }

    @SuppressWarnings("MultipleStringLiterals")
    private static String generateAdocReport(LogStatistic logStatistic) {
        StringBuilder report = new StringBuilder();

        String fromDate = DateParseUtils.fromODTtoISO(logStatistic.fromDate());
        String toDate = DateParseUtils.fromODTtoISO(logStatistic.toDate());

        report.append("==== Общая информация\n\n")
            .append("[cols=\"1,1\"]\n")
            .append("|===\n")
            .append("| Метрика | Значение\n")
            .append("| Файл(-ы) | `").append(String.join(", ", logStatistic.files())).append("`\n")
            .append("| Начальная дата | ").append(logStatistic.fromDate() != null ? fromDate : "-").append("\n")
            .append("| Конечная дата | ").append(logStatistic.toDate() != null ? toDate : "-").append("\n")
            .append("| Количество запросов | ").append(logStatistic.requestNumber()).append("\n")
            .append("| Средний размер ответа | ").append(logStatistic.meanBodyBytesSent()).append("b\n\n")
            .append("|===\n");

        report.append("==== Запрашиваемые ресурсы\n\n")
            .append("[cols=\"1,1\"]\n")
            .append("|===\n")
            .append("| Ресурс | Количество \n");

        for (Map.Entry<String, Integer> entry : logStatistic.sourceStatistic().entrySet()) {
            report.append("| `").append(entry.getKey()).append("` | ").append(entry.getValue()).append("\n");
        }
        report.append("|===\n\n");

        report.append("==== Коды ответа\n\n")
            .append("[cols=\"1,1,1\"]\n")
            .append("|===\n")
            .append("| Код | Имя | Количество \n");

        for (Map.Entry<Integer, Integer> entry : logStatistic.statusStatistic().entrySet()) {
            HttpStatus httpStatus = HttpStatus.valueOf(entry.getKey());
            report.append("| ").append(entry.getKey()).append(" | ").append(httpStatus.getReasonPhrase()).append(" | ")
                .append(entry.getValue()).append("\n");
        }
        report.append("|===\n");

        report.append("\n==== Типы запросов\n\n")
            .append("[cols=\"1,1\"]\n")
            .append("|===\n")
            .append("|  Тип запроса   | Количество\n");

        for (Map.Entry<String, Integer> entry : logStatistic.requestTypeStatistic().entrySet()) {
            report.append("| ").append(entry.getKey()).append(" | ").append(entry.getValue()).append("\n");
        }
        report.append("|===\n");

        report.append("\n==== Размеры ответов\n\n")
            .append("[cols=\"1,1\"]\n")
            .append("|===\n")
            .append("|  Размер ответа   | Количество \n");

        report.append("| 0 | ").append(logStatistic.bodyBytesSentStatistic().get("0"))
            .append("\n");
        report.append("| 0<...<1000 | ")
            .append(logStatistic.bodyBytesSentStatistic().get("0<...<1000"))
            .append("\n");
        report.append("| 1000<...<10000 | ")
            .append(logStatistic.bodyBytesSentStatistic().get("1000<...<10000"))
            .append("\n");
        report.append("| >10000 | ").append(logStatistic.bodyBytesSentStatistic().get(">10000"))
            .append("\n");
        report.append("|===\n");

        return report.toString();
    }

    @SuppressWarnings("MultipleStringLiterals")
    private static String generateConsoleReport(LogStatistic logStatistic) {
        StringBuilder report = new StringBuilder();

        String fromDate = DateParseUtils.fromODTtoISO(logStatistic.fromDate());
        String toDate = DateParseUtils.fromODTtoISO(logStatistic.toDate());

        report.append("Общая информация\n")
            .append("        Метрика        |       Значение     \n")
            .append("-----------------------|-------------------\n")
            .append("       Файл(-ы)        | `").append(String.join(", ", logStatistic.files())).append("`\n")
            .append("    Начальная дата     |  ").append(logStatistic.fromDate() != null ? fromDate : "-")
            .append("\n")
            .append("     Конечная дата     |  ").append(logStatistic.toDate() != null ? toDate : "-").append("\n")
            .append("  Количество запросов  |  ").append(logStatistic.requestNumber()).append("\n")
            .append(" Средний размер ответа |  ").append(logStatistic.meanBodyBytesSent()).append("b\n\n");

        String lineResourse = "----------------------------------";
        report.append("Запрашиваемые ресурсы\n")
            .append("              Ресурс              | Количество \n")
            .append(lineResourse)
            .append("|------------\n");

        for (Map.Entry<String, Integer> entry : logStatistic.sourceStatistic().entrySet()) {
            report.append("`").append(entry.getKey()).append("`");
            report.append(" ".repeat(Math.max(0, lineResourse.length() - entry.getKey().length() - 2)));
            report.append("| ").append(entry.getValue()).append("\n");
        }

        String lineName = "----------------------------------------------";
        report.append("\nКоды ответа\n")
            .append(" Код |                     Имя                      | Количество \n")
            .append("-----|")
            .append(lineName)
            .append("|------------\n");

        for (Map.Entry<Integer, Integer> entry : logStatistic.statusStatistic().entrySet()) {
            String httpStatus = HttpStatus.valueOf(entry.getKey()).getReasonPhrase();
            report.append(" ").append(entry.getKey()).append(" | ").append(httpStatus);
            report.append(" ".repeat(Math.max(0, lineName.length() - httpStatus.length() - 1)));
            report.append("| ").append(entry.getValue()).append("\n");
        }

        String lineType = "----------------";
        report.append("\nТипы запросов\n")
            .append("      Тип       | Количество \n")
            .append(lineType)
            .append("|------------\n");

        for (Map.Entry<String, Integer> entry : logStatistic.requestTypeStatistic().entrySet()) {
            report.append(" ").append(entry.getKey());
            report.append(" ".repeat(Math.max(0, lineType.length() - entry.getKey().length() - 1)));
            report.append("| ").append(entry.getValue()).append("\n");
        }

        report.append("\nРазмеры ответов\n")
            .append("  Размер ответа   | Количество \n")
            .append("------------------|------------\n");

        report.append("         0        | ").append(logStatistic.bodyBytesSentStatistic().get("0"))
            .append("\n");
        report.append("     0<...<1000   | ").append(logStatistic.bodyBytesSentStatistic().get("0<...<1000"))
            .append("\n");
        report.append("  1000<...<10000  | ").append(logStatistic.bodyBytesSentStatistic().get("1000<...<10000"))
            .append("\n");
        report.append("      >10000      | ").append(logStatistic.bodyBytesSentStatistic().get(">10000"))
            .append("\n");

        return report.toString();
    }
}
