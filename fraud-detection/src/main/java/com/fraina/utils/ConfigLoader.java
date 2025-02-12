package com.fraina.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

/**
 * Utility class to load external YAML configurations.
 */
public class ConfigLoader {
    private static final Map<String, Object> config;

    static {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("application.yaml")) {
            config = yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static Object getConfigValue(String key) {
        return config.get(key);
    }
}