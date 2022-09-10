package com.sysbot32.robotmc.core.minecraft;

import lombok.Getter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Properties {
    private static final String DEFAULT_FILENAME = "server.properties";
    private final String filename;
    private final Map<String, String> properties = new HashMap<>();

    public Properties() {
        this(DEFAULT_FILENAME);
    }

    public Properties(final String filename) {
        this.filename = filename;
        this.load();
    }

    public String get(final String key) {
        return this.properties.get(key);
    }

    public void set(final String key, final String value) {
        this.properties.put(key, value);
    }

    public void load() {
        final Path path = Paths.get(this.filename);
        if (Files.exists(path) && !Files.isDirectory(path)) {
            this.properties.clear();
            try {
                final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                for (final String line : lines) {
                    final String stripLine = line.strip();
                    if (stripLine.startsWith("#")) {
                        continue;
                    }
                    final String[] kv = stripLine.split("=");
                    this.properties.put(kv[0].strip(), kv[1].strip());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save() {
        try {
            Files.writeString(Paths.get(this.filename), this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> kv : this.properties.entrySet()) {
            stringBuilder.append(kv.getKey()).append("=").append(kv.getValue());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
