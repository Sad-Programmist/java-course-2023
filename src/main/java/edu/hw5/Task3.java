package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Pattern;

public class Task3 {

    private Task3() {
    }

    private static Optional<LocalDate> parseDate(String string) {
        if (string == null) {
            return Optional.empty();
        }

        DateTimeFormatter formatter = null;
        LocalDate date = null;

        if (Pattern.compile("^\\d{4}-\\d{2}-\\d{1,2}$").matcher(string).matches()) {
            formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        } else if (Pattern.compile("^\\d/\\d/\\d{4}$").matcher(string).matches()) {
            formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        } else if (Pattern.compile("^\\d/\\d/\\d{2}$").matcher(string).matches()) {
            formatter = DateTimeFormatter.ofPattern("d/M/yy");
        } else if (string.equalsIgnoreCase("tomorrow")) {
            date = LocalDate.now().plusDays(1);
        } else if (string.equalsIgnoreCase("today")) {
            date = LocalDate.now();
        } else if (string.equalsIgnoreCase("yesterday")) {
            date = LocalDate.now().minusDays(1);
        } else if (string.matches("\\d+\\s+day(s)?\\s+ago")) {
            int daysAgo = Integer.parseInt(string.split("\\s+")[0]);
            date = LocalDate.now().minusDays(daysAgo);
        }

        if (formatter != null) {
            date = LocalDate.parse(string, formatter);
        }

        return date == null ? Optional.empty() : Optional.of(date);
    }

    public static Optional<LocalDate> runTask3(String string) {
        return parseDate(string);
    }
}
