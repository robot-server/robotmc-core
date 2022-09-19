package com.sysbot32.robotmc.core.server.power;

import com.sysbot32.robotmc.core.driver.MinecraftServer;

import java.util.Objects;

public class PowerService {
    private static PowerService instance = null;
    private final MinecraftServer minecraftServer;

    private PowerService() {
        this.minecraftServer = MinecraftServer.getInstance();
    }

    public Power status() {
        return Power.INACTIVE;
    }

    public void start() {
        minecraftServer.start();
    }

    public void restart() {
        stop();
        start();
    }

    public void stop() {
        minecraftServer.stop();
    }

    public synchronized static PowerService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PowerService();
        }
        return instance;
    }
}
