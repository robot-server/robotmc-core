package com.sysbot32.robotmc.core.server;

import com.sysbot32.robotmc.core.server.logs.LogController;
import com.sysbot32.robotmc.core.server.plugins.PluginController;
import com.sysbot32.robotmc.core.server.power.PowerController;
import com.sysbot32.robotmc.core.server.properties.PropertiesController;
import com.sysbot32.robotmc.core.server.socket.WebSocketHandlerImpl;

import java.util.Objects;

import static spark.Spark.*;

public class ServerApplication {
    private static ServerApplication instance;

    private ServerApplication() {
        path(LogController.PATH, LogController.getInstance().getRouteGroup());
        path(PluginController.PATH, PluginController.getInstance().getRouteGroup());
        path(PowerController.PATH, PowerController.getInstance().getRouteGroup());
        path(PropertiesController.PATH, PropertiesController.getInstance().getRouteGroup());

        webSocket(WebSocketHandlerImpl.PATH, WebSocketHandlerImpl.class);

        init();
    }

    public synchronized static ServerApplication getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ServerApplication();
        }
        return instance;
    }
}
