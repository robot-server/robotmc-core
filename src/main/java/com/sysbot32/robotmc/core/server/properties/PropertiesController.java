package com.sysbot32.robotmc.core.server.properties;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

import static spark.Spark.*;


public class PropertiesController {
    private static PropertiesController instance = null;

    private PropertiesController() {
        path("/properties", () -> {
            get("", list);
            get("/:filename", retrieve);
            put("/:filename", update);
        });
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
