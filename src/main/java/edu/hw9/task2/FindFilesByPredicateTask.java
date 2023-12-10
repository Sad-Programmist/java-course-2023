package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FindFilesByPredicateTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final Predicate<File> predicate;

    FindFilesByPredicateTask(File directory, Predicate<File> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    protected List<File> compute() {
        File[] files = directory.listFiles();
        List<File> result = new ArrayList<>();
        if (files == null) {
            return result;
        }

        List<FindFilesByPredicateTask> subtasks = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                FindFilesByPredicateTask subtask =
                    new FindFilesByPredicateTask(file, predicate);
                subtasks.add(subtask);
                subtask.fork();
            } else {
                if (predicate.test(file)) {
                    result.add(file);
                }
            }
        }

        for (FindFilesByPredicateTask subtask : subtasks) {
            result.addAll(subtask.join());
        }

        return result;
    }
}
