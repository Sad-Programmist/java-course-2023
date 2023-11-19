package edu.hw6.task3;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    default AbstractFilter and(AbstractFilter other) {
        return path -> this.accept(path) && other.accept(path);
    }

    static AbstractFilter not(AbstractFilter other) {
        return path -> !other.accept(path);
    }

    static AbstractFilter smallerThan(long size) {
        return path -> Files.size(path) < size;
    }

    static AbstractFilter largerThan(long size) {
        return path -> Files.size(path) > size;
    }

    static AbstractFilter sizeEquals(long size) {
        return path -> Files.size(path) == size;
    }

    static AbstractFilter equalsOrSmallerThan(long size) {
        return path -> Files.size(path) <= size;
    }

    static AbstractFilter equalsOrLargerThan(long size) {
        return path -> Files.size(path) >= size;
    }

    static AbstractFilter magicNumber(int... magicBytes) {
        return path -> {
            try (SeekableByteChannel channel = Files.newByteChannel(path)) {
                ByteBuffer buffer = ByteBuffer.allocate(magicBytes.length);
                channel.read(buffer);
                buffer.flip();

                for (int magicByte : magicBytes) {
                    if (buffer.get() != (byte) magicByte) {
                        return false;
                    }
                }

                return true;
            } catch (BufferUnderflowException e) {
                LogManager.getLogger().error("Error in reading file: " + e.getMessage());
            }
            return false;
        };
    }

    static AbstractFilter globMatches(String fileExtension) {
        return path -> path.getFileName().toString().toLowerCase()
            .endsWith(fileExtension.toLowerCase().substring(1));
    }

    static AbstractFilter regexContains(String fileExtension) {
        Pattern pattern = Pattern.compile(fileExtension);
        return path -> pattern.matcher(path.getFileName().toString()).find();
    }

    static AbstractFilter regexMatches(String fileExtension) {
        Pattern pattern = Pattern.compile(fileExtension);
        return path -> pattern.matcher(path.getFileName().toString()).matches();
    }
}
