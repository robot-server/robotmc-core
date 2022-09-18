package com.sysbot32.robotmc.core.server.logs;

import com.sysbot32.robotmc.core.minecraft.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LogService {
    private static LogService instance = null;

    private LogService() {
    }

    public List<Log> listLogs() {
        return new ArrayList<>();
    }

    public Optional<Log> retrieveLog(final String filename) {
        return Optional.empty();
    }

    public synchronized static LogService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LogService();
        }
        return instance;
    }
}
