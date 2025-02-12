package com.fraina.sources;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import java.util.Properties;
import com.fraina.utils.ConfigLoader;

/**
 * KafkaTransactionSource sets up a Flink Kafka consumer to read transaction data.
 */
public class KafkaTransactionSource {
    public static FlinkKafkaConsumer<String> createSource() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", (String) ConfigLoader.getConfigValue("flink.kafka.bootstrapServers"));
        properties.setProperty("group.id", (String) ConfigLoader.getConfigValue("flink.kafka.groupId"));

        return new FlinkKafkaConsumer<>(
                (String) ConfigLoader.getConfigValue("flink.kafka.topic"),
                new SimpleStringSchema(),
                properties
        );
    }
}