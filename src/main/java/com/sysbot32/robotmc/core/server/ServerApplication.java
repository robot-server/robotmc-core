package com.sysbot32.robotmc.core.server;

import java.util.Objects;

import static spark.Spark.init;

public class ServerApplication {
    private static ServerApplication instance;

    private ServerApplication() {
        init();
    }

    public synchronized static ServerApplication getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ServerApplication();
        }
        return instance;
    }
}
