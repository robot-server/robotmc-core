package com.sysbot32.robotmc.core.server.power;

import java.util.Objects;

public class PowerService {
    private static PowerService instance = null;

    private PowerService() {
    }

    public Power status() {
        return Power.INACTIVE;
    }

    public void start() {
    }

    public void restart() {
        stop();
        start();
    }

    public void stop() {
    }

    public synchronized static PowerService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PowerService();
        }
        return instance;
    }
}
