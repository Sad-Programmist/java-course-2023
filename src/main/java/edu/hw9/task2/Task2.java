package edu.hw9.task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();
    private final static int THRESHOLD = 1000;

    private Task2() {
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static String runTask21(String directory) {
        if (directory == null || directory.isEmpty()) {
            return "";
        }

        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            File rootDirectory = new File(directory);

            int numberOfFiles =
                forkJoinPool.invoke(new CountFilesInDirectoryTask(rootDirectory));
            if (numberOfFiles > THRESHOLD) {
                String result = "Directory " + rootDirectory + " contains more than " + THRESHOLD + " files";
                LOGGER.info(result);
                return result;
            } else {
                String result = "There is no directories that contains more than " + THRESHOLD + " files";
                LOGGER.info(result);
                return result;
            }
        }
    }

    public static String runTask22(String directory, int fileSize, String extension) {
        if (directory == null || directory.isEmpty()) {
            return "";
        }

        if (fileSize == 0 && (extension == null || extension.isEmpty())) {
            return "";
        }

        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            File rootDirectory = new File(directory);

            Predicate<File> combinedPredicate =
                file -> file.length() > fileSize && file.getName().endsWith(extension);
            List<File>
                files =
                forkJoinPool.invoke(new FindFilesByPredicateTask(
                    rootDirectory,
                    combinedPredicate
                ));
            String result = "Files with size more than " + fileSize + "B and extension " + extension + ": "
                + files;
            LOGGER.info(result);
            return result;
        }
    }
}
