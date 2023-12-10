package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountFilesInDirectoryTask extends RecursiveTask<Integer> {
    private final File directory;

    CountFilesInDirectoryTask(File directory) {
        this.directory = directory;
    }

    @Override
    protected Integer compute() {
        File[] files = directory.listFiles();
        if (files == null) {
            return 0;
        }

        List<CountFilesInDirectoryTask> subtasks = new ArrayList<>();

        int count = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                CountFilesInDirectoryTask
                    subtask = new CountFilesInDirectoryTask(file);
                subtasks.add(subtask);
                subtask.fork();
            } else {
                count++;
            }
        }

        for (CountFilesInDirectoryTask subtask : subtasks) {
            count += subtask.join();
        }

        return count;
    }
}
