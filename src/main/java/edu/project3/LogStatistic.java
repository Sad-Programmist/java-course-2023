package edu.project3;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public record LogStatistic(List<String> files, OffsetDateTime fromDate, OffsetDateTime toDate, int requestNumber,
                           long meanBodyBytesSent, Map<String, Integer> sourceStatistic,
                           Map<Integer, Integer> statusStatistic, Map<String, Integer> requestTypeStatistic,
                           Map<String, Integer> bodyBytesSentStatistic) {

}
