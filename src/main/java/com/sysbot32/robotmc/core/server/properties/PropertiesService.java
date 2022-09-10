package com.sysbot32.robotmc.core.server.properties;

import com.sysbot32.robotmc.core.minecraft.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PropertiesService {
    public static List<Properties> listProperties() {
        return new ArrayList<>();
    }

    public static Optional<Properties> retrieveProperties(final String filename) {
        return Optional.empty();
    }

    public static Optional<Properties> updateProperties(final String filename, final Map<String, String> properties) {
        return Optional.empty();
    }
}
