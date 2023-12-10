package edu.hw9;

import edu.hw9.task1.MetricStats;
import edu.hw9.task1.StatsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Многопоточная передача данных (5 потоков)")
    void statsCollectorPush1() {
        // given
        int threadNumber = 5;

        // when
        StatsCollector collector = new StatsCollector(threadNumber);
        ExecutorService dataPushExecutor = Executors.newFixedThreadPool(threadNumber);

        dataPushExecutor.submit(() -> {
            collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric2", new double[] {2.0, 3.5, 1.8, 4.2, 0.7});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric3", new double[] {3, 4, 3});
        });

        dataPushExecutor.shutdown();
        while (!dataPushExecutor.isTerminated()) {
        }

        // then
        Map<String, List<Double>> expected =
            Map.of("metric1", List.of(0.1, 0.05, 1.4, 5.1, 0.3),
                "metric2", List.of(2.0, 3.5, 1.8, 4.2, 0.7),
                "metric3", List.of(3.0, 4.0, 3.0)
            );
        assertThat(collector.getDataMap())
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Многопоточная передача данных (1 поток)")
    void statsCollectorPush2() {
        // given
        int threadNumber = 1;

        // when
        StatsCollector collector = new StatsCollector(threadNumber);
        ExecutorService dataPushExecutor = Executors.newFixedThreadPool(threadNumber);

        dataPushExecutor.submit(() -> {
            collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric2", new double[] {2.0, 3.5, 1.8, 4.2, 0.7});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric3", new double[] {3, 4, 3});
        });

        dataPushExecutor.shutdown();
        while (!dataPushExecutor.isTerminated()) {
        }

        // then
        Map<String, List<Double>> expected =
            Map.of("metric1", List.of(0.1, 0.05, 1.4, 5.1, 0.3),
                "metric2", List.of(2.0, 3.5, 1.8, 4.2, 0.7),
                "metric3", List.of(3.0, 4.0, 3.0)
            );
        assertThat(collector.getDataMap())
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Многопоточная передача данных с null ключом")
    void statsCollectorPush3() {
        // given
        int threadNumber = 5;

        // when
        StatsCollector collector = new StatsCollector(threadNumber);
        ExecutorService dataPushExecutor = Executors.newFixedThreadPool(threadNumber);

        dataPushExecutor.submit(() -> {
            collector.push(null, new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric2", new double[] {2.0, 3.5, 1.8, 4.2, 0.7});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric3", new double[] {3, 4, 3});
        });

        dataPushExecutor.shutdown();
        while (!dataPushExecutor.isTerminated()) {
        }

        // then
        Map<String, List<Double>> expected =
            Map.of("metric2", List.of(2.0, 3.5, 1.8, 4.2, 0.7),
                "metric3", List.of(3.0, 4.0, 3.0)
            );
        assertThat(collector.getDataMap())
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Многопоточная передача данных с null значением")
    void statsCollectorPush4() {
        // given
        int threadNumber = 5;

        // when
        StatsCollector collector = new StatsCollector(threadNumber);
        ExecutorService dataPushExecutor = Executors.newFixedThreadPool(threadNumber);

        dataPushExecutor.submit(() -> {
            collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric2", null);
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric3", new double[] {3, 4, 3});
        });

        dataPushExecutor.shutdown();
        while (!dataPushExecutor.isTerminated()) {
        }

        // then
        Map<String, List<Double>> expected =
            Map.of("metric1", List.of(0.1, 0.05, 1.4, 5.1, 0.3),
                "metric3", List.of(3.0, 4.0, 3.0)
            );
        assertThat(collector.getDataMap())
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Многопоточный рассчет статистики (5 потоков)")
    void statsCollectorStats1() {
        // given
        int threadNumber = 5;

        // when
        StatsCollector collector = new StatsCollector(threadNumber);
        ExecutorService dataPushExecutor = Executors.newFixedThreadPool(threadNumber);

        dataPushExecutor.submit(() -> {
            collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric2", new double[] {2.0, 3.5, 1.8, 4.2, 0.7});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric3", new double[] {3, 4, 3});
        });

        dataPushExecutor.shutdown();
        while (!dataPushExecutor.isTerminated()) {
        }

        List<MetricStats> result = collector.stats();

        // then
        List<MetricStats> expected = List.of(
            new MetricStats("metric1", 6.949999999999999, 1.39, 5.1, 0.05),
            new MetricStats("metric2", 12.2, 2.44, 4.2, 0.7),
            new MetricStats("metric3", 10.0, 3.3333333333333335, 4.0, 3.0)
        );

        assertThat(result)
            .usingRecursiveComparison()
            .ignoringCollectionOrder()
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Многопоточный рассчет статистики (1 поток)")
    void statsCollectorStats2() {
        // given
        int threadNumber = 1;

        // when
        StatsCollector collector = new StatsCollector(threadNumber);
        ExecutorService dataPushExecutor = Executors.newFixedThreadPool(threadNumber);

        dataPushExecutor.submit(() -> {
            collector.push("metric1", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric2", new double[] {2.0, 3.5, 1.8, 4.2, 0.7});
        });

        dataPushExecutor.submit(() -> {
            collector.push("metric3", new double[] {3, 4, 3});
        });

        dataPushExecutor.shutdown();
        while (!dataPushExecutor.isTerminated()) {
        }

        List<MetricStats> result = collector.stats();

        // then
        List<MetricStats> expected = List.of(
            new MetricStats("metric1", 6.949999999999999, 1.39, 5.1, 0.05),
            new MetricStats("metric2", 12.2, 2.44, 4.2, 0.7),
            new MetricStats("metric3", 10.0, 3.3333333333333335, 4.0, 3.0)
        );

        assertThat(result)
            .usingRecursiveComparison()
            .ignoringCollectionOrder()
            .isEqualTo(expected);
    }
}
