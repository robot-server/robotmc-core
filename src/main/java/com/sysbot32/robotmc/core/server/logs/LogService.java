package com.sysbot32.robotmc.core.server.logs;

import com.sysbot32.robotmc.core.minecraft.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogService {
    public static List<Log> listLogs() {
        return new ArrayList<>();
    }

    public static Optional<Log> retrieveLog(final String filename) {
        return Optional.empty();
    }
}
