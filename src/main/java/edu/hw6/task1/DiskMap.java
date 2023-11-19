package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private String filePath;
    private Map<String, String> inMemoryMap;
    private static final Logger LOGGER = LogManager.getLogger();

    public DiskMap(String filePath) {
        this.filePath = filePath;
        this.inMemoryMap = new HashMap<>();
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.error("Error creating file: " + e.getMessage());
            }
        }
        loadFromDisk();
    }

    private void loadFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    inMemoryMap.put(key, value);
                }
            }
        } catch (IOException e) {
            LOGGER.error("Error loading data from disk: " + e.getMessage());
        }
    }

    private void saveToDisk() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry<String, String> entry : inMemoryMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            LOGGER.error("Error saving data to disk: " + e.getMessage());
        }
    }

    @Override
    public int size() {
        return inMemoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return inMemoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return inMemoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return inMemoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return inMemoryMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String newValue = inMemoryMap.put(key, value);
        saveToDisk();
        return newValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = inMemoryMap.remove(key);
        saveToDisk();
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        inMemoryMap.putAll(m);
        saveToDisk();
    }

    @Override
    public void clear() {
        inMemoryMap.clear();
        saveToDisk();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return inMemoryMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return inMemoryMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return inMemoryMap.entrySet();
    }
}
