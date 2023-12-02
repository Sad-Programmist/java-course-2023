package edu.project3.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadUtils {

    private final static Logger LOGGER = LogManager.getLogger();

    private ReadUtils() {
    }

    public static List<String> readFile(String path) {
        List<String> result = new ArrayList<>();

        if (path != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
            } catch (IOException e) {
                LOGGER.error("Error reading from file '{}': {}", path, e.getMessage());
            }
        }

        return result;
    }

    public static List<String> readMultipleFiles(String path) {
        List<File> files = getFiles(path);
        List<String> result = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    result.addAll(readFile(file.getAbsolutePath()));
                }
            }
        }
        return result;
    }

    public static List<File> getFiles(String path) {
        List<File> result = new ArrayList<>();
        if (path != null) {
            File directory = new File(path);
            File[] files = directory.listFiles();
            if (files != null) {
                result = List.of(files);
            } else {
                LOGGER.error("Directory '{}' does not exist or is not a directory", path);
            }
        }
        return result;
    }

    public static List<String> readFromURL(String path) {
        List<String> result = new ArrayList<>();

        if (path != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(path).openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.add(line);
                }
            } catch (IOException e) {
                LOGGER.error("Error reading from URL '{}': {}", path, e.getMessage());
            }
        }
        return result;
    }
}
