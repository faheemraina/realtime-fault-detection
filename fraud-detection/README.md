## Overview
This project simulates a real-time financial transaction pipeline using Apache Kafka and Apache Flink, built with **Maven** and targeting **Java 17**.

## Project Structure
```
realtime-fault-detection/
│-- docker-compose.yml
│-- config/
│   │-- application.yaml
│-- kafka_producer/
│   │-- producer.py
│   │-- requirements.txt
│-- flink_pipeline/
│   │-- src/main/java/com/fraina/
│   │   │-- operators/
│   │   │   │-- FilteringFunction.java
│   │   │   │-- FeatureExtractionFunction.java
│   │   │   │-- AnomalyDetectionFunction.java
│   │   │   │-- AlertFunction.java
│   │   │-- sources/
│   │   │   │-- KafkaTransactionSource.java
│   │   │-- utils/
│   │   │   │-- Constants.java
│   │   │   │-- UtilityFunctions.java
│   │   │   │-- ConfigLoader.java
│   │   │-- pipeline/
│   │   │   │-- FraudDetectionPipeline.java
│   │   │-- interfaces/
│   │   │   │-- TransactionProcessor.java
│   │-- pom.xml
│-- README.md
```

## Build and Run

### Compile the Project
```bash
mvn clean package
```

### Run the Flink Pipeline
```bash
flink run -c com.fraina.pipeline.FraudDetectionPipeline target/flink-fraud-detection-1.0-SNAPSHOT.jar
```

## Configuration
The application uses an external **application.yaml** configuration file to manage environment settings, Kafka, Redis, and Cassandra configurations.

## Next Steps
- Implement feature extraction and anomaly detection logic.
- Train fraud detection models using Apache Spark ML.
- Store results in Redis/Cassandra.
- Visualize alerts and patterns with Grafana/Kibana.