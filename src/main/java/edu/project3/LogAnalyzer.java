package edu.project3;

import edu.project3.utils.DateParseUtils;
import edu.project3.utils.ReadUtils;
import java.io.File;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAnalyzer {

    private LogSourceType logSourceType = LogSourceType.UNKNOWN;

    private static final String FILE_EXTENSION_TXT = ".txt";
    private static final String FILE_EXTENSION_LOG = ".log";
    private static final String LOG_SOURCE_MULTIPLE = "*";
    private static final String PROTOCOL_HTTP = "http";
    private static final String ZERO = "0";
    private static final String THOUSAND = "0<...<1000";
    private static final String TEN_THOUSAND = "1000<...<10000";
    private static final String MORE_TEN_THOUSAND = ">10000";

    @SuppressWarnings({"CyclomaticComplexity", "MagicNumber"})
    public LogStatistic analyzeLogs(String path, String from, String to) {
        if (path == null) {
            return null;
        }

        OffsetDateTime fromDate = null;
        OffsetDateTime toDate = null;
        if (from != null) {
            fromDate = DateParseUtils.fromISOtoODT(from);
        }
        if (to != null) {
            toDate = DateParseUtils.fromISOtoODT(to);
        }

        List<String> stringLogs = read(path);
        if (stringLogs.isEmpty()) {
            return new LogStatistic(
                getFiles(path),
                fromDate,
                toDate,
                0,
                0,
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap()
            );
        }

        List<Log> logs = new ArrayList<>();
        for (String log : stringLogs) {
            Log nginxLog = parseLog(log, fromDate, toDate);
            if (nginxLog != null) {
                logs.add(nginxLog);
            }
        }

        if (logs.isEmpty()) {
            return new LogStatistic(
                getFiles(path),
                fromDate,
                toDate,
                0,
                0,
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap()
            );
        }

        int requestNumber = logs.size();

        Map<String, Integer> sourceStatistic = new HashMap<>();
        Map<Integer, Integer> statusStatistic = new HashMap<>();
        Map<String, Integer> requestTypeStatistic = new HashMap<>();
        Map<String, Integer> bodyBytesSentStatistic =
            new HashMap<>(Map.of(ZERO, 0, THOUSAND, 0, TEN_THOUSAND, 0, MORE_TEN_THOUSAND, 0));
        long sumBodyBytesSent = 0;

        for (Log log : logs) {
            String tempSource = log.getRequestedSource();
            if (!sourceStatistic.containsKey(tempSource)) {
                sourceStatistic.put(tempSource, 1);
            } else {
                int times = sourceStatistic.get(tempSource);
                sourceStatistic.replace(tempSource, times + 1);
            }

            int tempStatus = log.getStatus();
            if (!statusStatistic.containsKey(tempStatus)) {
                statusStatistic.put(tempStatus, 1);
            } else {
                int times = statusStatistic.get(tempStatus);
                statusStatistic.replace(tempStatus, times + 1);
            }

            String tempType = log.getRequestType();
            if (!requestTypeStatistic.containsKey(tempType)) {
                requestTypeStatistic.put(tempType, 1);
            } else {
                int times = requestTypeStatistic.get(tempType);
                requestTypeStatistic.replace(tempType, times + 1);
            }

            long tempBodyBytesSent = log.getBodyBytesSent();
            if (tempBodyBytesSent == 0) {
                int times = bodyBytesSentStatistic.get(ZERO);
                bodyBytesSentStatistic.replace(ZERO, times + 1);
            }
            if (tempBodyBytesSent > 0 && tempBodyBytesSent < 1000) {
                int times = bodyBytesSentStatistic.get(THOUSAND);
                bodyBytesSentStatistic.replace(THOUSAND, times + 1);
            }
            if (tempBodyBytesSent > 1000 && tempBodyBytesSent < 10000) {
                int times = bodyBytesSentStatistic.get(TEN_THOUSAND);
                bodyBytesSentStatistic.replace(TEN_THOUSAND, times + 1);
            }
            if (tempBodyBytesSent > 10000) {
                int times = bodyBytesSentStatistic.get(MORE_TEN_THOUSAND);
                bodyBytesSentStatistic.replace(MORE_TEN_THOUSAND, times + 1);
            }

            sumBodyBytesSent += log.getBodyBytesSent();
        }

        long meanBodyBytesSent = sumBodyBytesSent / requestNumber;

        return new LogStatistic(
            getFiles(path),
            fromDate,
            toDate,
            requestNumber,
            meanBodyBytesSent,
            sourceStatistic,
            statusStatistic,
            requestTypeStatistic,
            bodyBytesSentStatistic
        );
    }

    private List<String> read(String path) {
        if (path != null) {
            if (path.endsWith(LOG_SOURCE_MULTIPLE)) {
                logSourceType = LogSourceType.MULTIPLE;
                return ReadUtils.readMultipleFiles(path.substring(0, path.length() - 1));
            }
            if (path.endsWith(FILE_EXTENSION_TXT) || path.endsWith(FILE_EXTENSION_LOG)) {
                logSourceType = LogSourceType.FILE;
                return ReadUtils.readFile(path);
            }
            if (path.startsWith(PROTOCOL_HTTP)) {
                logSourceType = LogSourceType.URL;
                return ReadUtils.readFromURL(path);
            }
        }
        return null;
    }

    private Log parseLog(String string, OffsetDateTime fromDate, OffsetDateTime toDate) {
        if (string == null) {
            return null;
        }
        String[] logParts = string.split("\"");
        String[] dateParts = logParts[0].split("]")[0].split("\\[");
        OffsetDateTime timeLocal = DateParseUtils.fromCLFtoODT(dateParts[1]);

        if (isCorrectDate(fromDate, timeLocal, toDate)) {
            String[] request = logParts[1].split(" ");
            String requestType = request[0];
            String[] requestedPath = request[1].split("/");
            String requestedSource = requestedPath[requestedPath.length - 1];

            String[] responseParts = logParts[2].split(" ");
            int status = Integer.parseInt(responseParts[1]);
            long bodyBytesSent = Long.parseLong(responseParts[2]);

            return new Log(timeLocal, requestType, requestedSource, status, bodyBytesSent);
        }
        return null;
    }

    private boolean isCorrectDate(OffsetDateTime from, OffsetDateTime now, OffsetDateTime to) {
        return (from == null || now.isAfter(from)) && (to == null || now.isBefore(to));
    }

    private List<String> getFiles(String path) {
        List<String> files;

        switch (logSourceType) {
            case MULTIPLE -> {
                List<File> tempFiles = ReadUtils.getFiles(path.substring(0, path.indexOf("*")));
                files = tempFiles.stream().map(File::getName).toList();
            }
            case FILE -> {
                String[] pathParts = path.split("/");
                files = List.of(pathParts[pathParts.length - 1]);
            }
            case URL -> {
                files = List.of(path);
            }
            default -> {
                files = null;
            }
        }
        return files;
    }
}
