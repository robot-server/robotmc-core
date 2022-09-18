package com.sysbot32.robotmc.core.server.plugins;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.path;

public class PluginController {
    public static final Route list = (final Request request, final Response response) -> {
        return "list";
    };

    public static final Route retrieve = (final Request request, final Response response) -> {
        final String filename = request.params(":filename");
        return "retrieve";
    };

    static {
        path("/plugins", () -> {
            get("", list);
            get("/:filename", retrieve);
        });
    }
}
