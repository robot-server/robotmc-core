package com.sysbot32.robotmc.core.server.power;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

import static spark.Spark.*;

public class PowerController {
    private static PowerController instance = null;

    private PowerController() {
        path("/power", () -> {
            get("", status);
            post("", start);
            put("", restart);
            delete("", stop);
        });
    }

    public final Route status = (final Request request, final Response response) -> {
        return "status";
    };

    public final Route start = (final Request request, final Response response) -> {
        return "start";
    };

    public final Route restart = (final Request request, final Response response) -> {
        return "restart";
    };

    public final Route stop = (final Request request, final Response response) -> {
        return "stop";
    };

    public synchronized static PowerController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PowerController();
        }
        return instance;
    }
}
