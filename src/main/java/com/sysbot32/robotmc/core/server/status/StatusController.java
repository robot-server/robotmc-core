package com.sysbot32.robotmc.core.server.status;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.path;

public class StatusController {
    public static final Route status = (final Request request, final Response response) -> {
        return "status";
    };

    static {
        path("/status", () -> {
            get("", status);
        });
    }
}
