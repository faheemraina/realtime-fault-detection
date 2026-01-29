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

   /* public static Object getConfigValue_x(String key) {
        return config.get(key);
    }*/

    /**
     * Get a configuration value by key. Supports nested keys using dot notation (e.g., "flink.kafka.bootstrapServers").
     *
     * @param key The configuration key (e.g., "flink.kafka.bootstrapServers").
     * @return The configuration value, or null if the key is not found.
     */
    public static Object getConfigValue(String key) {
        String[] keys = key.split("\\.");
        Map<String, Object> currentMap = config;

        // Traverse the nested maps
        for (int i = 0; i < keys.length - 1; i++) {
            Object value = currentMap.get(keys[i]);
            if (value instanceof Map) {
                currentMap = (Map<String, Object>) value;
            } else {
                return null; // Key not found
            }
        }

        // Return the final value
        return currentMap.get(keys[keys.length - 1]);
    }
}