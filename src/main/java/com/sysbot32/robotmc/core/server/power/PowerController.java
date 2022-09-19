package com.sysbot32.robotmc.core.server.power;

import lombok.Getter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.RouteGroup;

import java.util.Objects;

import static spark.Spark.*;

public class PowerController {
    private static PowerController instance = null;

    public static final String PATH = "/power";
    @Getter
    private final RouteGroup routeGroup;
    private final PowerService service = PowerService.getInstance();

    private PowerController() {
        this.routeGroup = () -> {
            get("", status);
            post("", start);
            put("", restart);
            delete("", stop);
        };
    }

    public final Route status = (final Request request, final Response response) -> {
        return service.status();
    };

    public final Route start = (final Request request, final Response response) -> {
        service.start();
        return "start";
    };

    public final Route restart = (final Request request, final Response response) -> {
        service.restart();
        return "restart";
    };

    public final Route stop = (final Request request, final Response response) -> {
        service.stop();
        return "stop";
    };

    public synchronized static PowerController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PowerController();
        }
        return instance;
    }
}
