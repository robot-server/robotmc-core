package com.sysbot32.robotmc.core.server.properties;

import com.sysbot32.robotmc.core.minecraft.Properties;

import java.util.*;

public class PropertiesService {
    private static PropertiesService instance = null;

    private PropertiesService() {
    }

    public List<Properties> listProperties() {
        return new ArrayList<>();
    }

    public Optional<Properties> retrieveProperties(final String filename) {
        return Optional.empty();
    }

    public Optional<Properties> updateProperties(final String filename, final Map<String, String> properties) {
        return Optional.empty();
    }

    public synchronized static PropertiesService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PropertiesService();
        }
        return instance;
    }
}
