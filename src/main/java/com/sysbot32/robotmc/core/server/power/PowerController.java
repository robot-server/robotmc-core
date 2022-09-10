package com.sysbot32.robotmc.core.server.power;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class PowerController {
    public static final Route status = (final Request request, final Response response) -> {
        return "status";
    };

    public static final Route start = (final Request request, final Response response) -> {
        return "start";
    };

    public static final Route restart = (final Request request, final Response response) -> {
        return "restart";
    };

    public static final Route stop = (final Request request, final Response response) -> {
        return "stop";
    };

    static {
        path("/power", () -> {
            get("", status);
            post("", start);
            put("", restart);
            delete("", stop);
        });
    }
}
