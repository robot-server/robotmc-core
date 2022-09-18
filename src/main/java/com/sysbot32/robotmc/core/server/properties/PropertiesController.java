package com.sysbot32.robotmc.core.server.properties;

import lombok.Getter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.RouteGroup;

import java.util.Objects;

import static spark.Spark.get;
import static spark.Spark.put;

public class PropertiesController {
    private static PropertiesController instance = null;

    public static final String PATH = "/properties";
    @Getter
    private final RouteGroup routeGroup;

    private PropertiesController() {
        this.routeGroup = () -> {
            get("", list);
            get("/:filename", retrieve);
            put("/:filename", update);
        };
    }

    public final Route list = (final Request request, final Response response) -> {
        return "list";
    };

    public final Route retrieve = (final Request request, final Response response) -> {
        final String filename = request.params(":filename");
        return "retrieve";
    };

    public final Route update = (final Request request, final Response response) -> {
        final String filename = request.params(":filename");
        return "update";
    };

    public synchronized static PropertiesController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PropertiesController();
        }
        return instance;
    }
}
