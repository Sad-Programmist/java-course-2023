package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task2() {
    }

    private static void cloneFile(Path filePath) {
        if (!Files.exists(filePath)) {
            LOGGER.error("File does not exist.");
            return;
        }

        Path directory = filePath.getParent();
        String fileName = filePath.getFileName().toString();
        String baseName = getBaseName(fileName);
        String extension = getFileExtension(fileName);

        int copyNumber = 1;
        Path newFilePath;

        do {
            String copySuffix =
                (copyNumber == 1) ? "" : " — копия" + ((copyNumber == 2) ? "" : " (" + (copyNumber - 1) + ")");
            String newFileName = baseName + copySuffix + extension;
            newFilePath = directory.resolve(newFileName);
            copyNumber++;
        } while (Files.exists(newFilePath));

        try {
            Files.copy(filePath, newFilePath, StandardCopyOption.COPY_ATTRIBUTES);
            LOGGER.info("File successfully copied: " + newFilePath);
        } catch (IOException e) {
            LOGGER.error("Error copying file: " + e.getMessage());
        }
    }

    private static String getBaseName(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }

    public static void runTask2(Path path) {
        cloneFile(path);
    }
}
