package edu.project3.utils;

import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateParseUtils {

    private final static Logger LOGGER = LogManager.getLogger();
    private final static String ERROR_MESSAGE = "Input date is null.";

    private DateParseUtils() {
    }

    public static OffsetDateTime fromCLFtoODT(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        if (date != null) {
            try {
                return OffsetDateTime.parse(date, formatter);
            } catch (DateTimeParseException e) {
                LOGGER.error("Error parsing CLF date: " + date);
            }
        }
        LOGGER.error(ERROR_MESSAGE);
        return null;
    }

    public static OffsetDateTime fromISOtoODT(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        if (date != null) {
            try {
                return OffsetDateTime.parse(date + "T00:00:00Z", formatter);
            } catch (DateTimeParseException e) {
                LOGGER.error("Error parsing ISO date: " + date);
            }
        }
        LOGGER.error(ERROR_MESSAGE);
        return null;
    }

    public static String fromODTtoISO(OffsetDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (date != null) {
            try {
                return date.format(formatter);
            } catch (DateTimeException e) {
                LOGGER.error("Error formatting date to ISO: " + date);
            }
        }
        LOGGER.error(ERROR_MESSAGE);
        return null;
    }
}
