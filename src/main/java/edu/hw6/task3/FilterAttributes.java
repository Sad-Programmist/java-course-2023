package edu.hw6.task3;

import java.nio.file.Files;

public class FilterAttributes {

    private FilterAttributes() {
    }

    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;
    public static final AbstractFilter WRITABLE = Files::isWritable;
    public static final AbstractFilter DIRECTORY = Files::isDirectory;
    public static final AbstractFilter EXECUTABLE = Files::isExecutable;
    public static final AbstractFilter HIDDEN = Files::isHidden;
}
