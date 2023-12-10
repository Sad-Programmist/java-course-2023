package edu.hw9.task3;

import edu.hw9.task2.Predicate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class DFSTask implements Callable<List<File>> {
    private final File directory;
    private final Predicate<File> predicate;

    DFSTask(File directory, Predicate<File> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    public List<File> call() {
        return depthFirstSearch(directory);
    }

    private List<File> depthFirstSearch(File currentDirectory) {
        List<File> result = new ArrayList<>();
        File[] files = currentDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DFSTask subtask = new DFSTask(file, predicate);
                    result.addAll(subtask.depthFirstSearch(file));
                } else {
                    if (predicate.test(file)) {
                        result.add(file);
                    }
                }
            }
        }

        return result;
    }
}
