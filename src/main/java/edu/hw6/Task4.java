package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    private static void writeTextToFile(String filePath, String text) {
        Path outputPath = Path.of(filePath);

        try (OutputStream fileOutputStream = Files.newOutputStream(outputPath, StandardOpenOption.CREATE);
             CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {

            printWriter.println(text);

            LOGGER.info("Text successfully written to the file: " + outputPath);

        } catch (IOException e) {
            LOGGER.error("Error writing to the file: " + e.getMessage());
        }
    }

    public static void runTask4(String filePath, String text) {
        writeTextToFile(filePath, text);
    }
}
