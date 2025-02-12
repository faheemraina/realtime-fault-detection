package com.fraina.utils;

/**
 * Constants used across the Flink fraud detection pipeline.
 */
public class Constants {
    public static final String KAFKA_TOPIC = "transactions";
    public static final String KAFKA_BROKER = "localhost:9092";
    public static final String REDIS_HOST = "localhost";
    public static final int REDIS_PORT = 6379;
    public static final String CASSANDRA_HOST = "localhost";
    public static final String CASSANDRA_KEYSPACE = "fraud_detection";
}