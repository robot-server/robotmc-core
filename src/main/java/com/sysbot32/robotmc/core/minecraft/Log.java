package com.sysbot32.robotmc.core.minecraft;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Log {
    private static final String DEFAULT_FILENAME = "latest.log";
    private final String filename;
    private final List<String> logs = new ArrayList<>();

    public Log() {
        this(DEFAULT_FILENAME);
    }

    public Log(final String filename) {
        this.filename = filename;
        load();
    }

    public void load() {
        final Path path = Paths.get(this.filename);
        if (Files.exists(path) && !Files.isDirectory(path)) {
            this.logs.clear();
            try {
                final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                Collections.copy(this.logs, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return String.join("\n", this.logs);
    }
}
