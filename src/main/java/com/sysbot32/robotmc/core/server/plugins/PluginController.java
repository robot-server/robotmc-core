package com.sysbot32.robotmc.core.server.plugins;

import lombok.Getter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.RouteGroup;

import java.util.Objects;

import static spark.Spark.get;

public class PluginController {
    private static PluginController instance = null;

    public static final String PATH = "/plugins";
    @Getter
    private final RouteGroup routeGroup;

    private PluginController() {
        this.routeGroup = () -> {
            get("", list);
            get("/:filename", retrieve);
        };
    }

    public final Route list = (final Request request, final Response response) -> {
        return "list";
    };

    public final Route retrieve = (final Request request, final Response response) -> {
        final String filename = request.params(":filename");
        return "retrieve";
    };

    public synchronized static PluginController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PluginController();
        }
        return instance;
    }
}
