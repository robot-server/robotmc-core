package com.sysbot32.robotmc.core.server.properties;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;


public class PropertiesController {
    public static final Route list = (final Request request, final Response response) -> {
        return "list";
    };

    public static final Route retrieve = (final Request request, final Response response) -> {
        final String filename = request.params(":filename");
        return "retrieve";
    };

    public static final Route update = (final Request request, final Response response) -> {
        final String filename = request.params(":filename");
        return "update";
    };

    static {
        path("/properties", () -> {
            get("", list);
            get("/:filename", retrieve);
            put("/:filename", update);
        });
    }
}
