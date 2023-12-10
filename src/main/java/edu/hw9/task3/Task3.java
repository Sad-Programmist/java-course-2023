package edu.hw9.task3;

import edu.hw9.task2.Predicate;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task3() {
    }

    public static List<File> runTask3(String directory, String filename) {
        if (directory == null || directory.isEmpty() || filename == null || filename.isEmpty()) {
            return Collections.emptyList();
        }

        File rootDirectory = new File(directory);
        Predicate<File> namePredicate = file -> file.getName().equals(filename);

        int parallelismLevel = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(parallelismLevel);

        DFSTask rootTask = new DFSTask(rootDirectory, namePredicate);
        Future<List<File>> futureResult = executorService.submit(rootTask);

        List<File> result;
        try {
            result = futureResult.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        return result;
    }
}
