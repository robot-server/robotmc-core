package com.sysbot32.robotmc.core.server.logs;

import lombok.Getter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.RouteGroup;

import java.util.Objects;

import static spark.Spark.get;

public class LogController {
    private static LogController instance = null;

    public static final String PATH = "/logs";
    @Getter
    private final RouteGroup routeGroup;

    private LogController() {
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

    public synchronized static LogController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LogController();
        }
        return instance;
    }
}
