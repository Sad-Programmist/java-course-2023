package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {

    private static final int DAY = 13;
    private static final int NUMBER_OF_MONTHS = 12;

    private Task2() {
    }

    private static List<LocalDate> findFridayThe13th(int year) {
        if (year < LocalDate.MIN.getYear() || year > LocalDate.MAX.getYear()) {
            return Collections.emptyList();
        }
        List<LocalDate> fridayThe13ths = new ArrayList<>();

        for (int month = 1; month <= NUMBER_OF_MONTHS; month++) {
            LocalDate date = LocalDate.of(year, month, DAY);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThe13ths.add(date);
            }
        }

        return fridayThe13ths;
    }

    private static LocalDate nextFridayThe13th(LocalDate currentDate) {
        if (currentDate == null) {
            return null;
        }
        LocalDate nextFriday = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (nextFriday.getDayOfMonth() != DAY) {
            nextFriday = nextFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return nextFriday;
    }

    public static List<LocalDate> runTask21(int year) {
        return findFridayThe13th(year);
    }

    public static LocalDate runTask22(LocalDate currentDate) {
        return nextFridayThe13th(currentDate);
    }
}
