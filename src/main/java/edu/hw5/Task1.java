package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {

    private Task1() {
    }

    private static String averageSessionDuration(List<String> sessions) {
        if (sessions == null) {
            return "";
        }
        int minutesSum = 0;
        int sessionsCount = 0;
        for (String session : sessions) {
            if (session != null) {
                String[] startEnd = session.split(" - ");
                var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
                LocalDateTime startDate = LocalDateTime.parse(startEnd[0], formatter);
                LocalDateTime endDate = LocalDateTime.parse(startEnd[1], formatter);
                Duration duration = Duration.between(startDate, endDate);
                minutesSum += duration.toMinutes();
                sessionsCount++;
            }
        }

        minutesSum /= sessionsCount;
        Duration averageDuration = Duration.ofMinutes(minutesSum);
        int days = (int) averageDuration.toDaysPart();
        int hours = averageDuration.toHoursPart();
        int minutes = averageDuration.toMinutesPart();

        String result = new StringBuilder()
            .append(days == 0 ? "" : days + "д ")
            .append(hours == 0 ? "" : hours + "ч ")
            .append(minutes == 0 ? "" : minutes + "м ")
            .toString();
        return result.trim();
    }

    public static String runTask1(List<String> sessions) {
        return averageSessionDuration(sessions);
    }
}
