package com.sysbot32.robotmc.core.server.power;

public class PowerService {
    public static Power status() {
        return Power.INACTIVE;
    }

    public static void start() {
    }

    public static void restart() {
        stop();
        start();
    }

    public static void stop() {
    }
}
