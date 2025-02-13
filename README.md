# Real-time Fraud Detection in Financial Transactions

## Overview
This project implements a **real-time fraud detection system** using:
- **Docker Compose** to orchestrate dependencies.
- **Kafka Producer** to generate mock financial transactions.
- **Apache Flink** to process transactions and detect fraud.

- Real-time streaming capability makes it ideal for detecting fraud as transactions occur.
- Can be integrated with Kafka for ingestion and Redis for fast lookups.
## Project Src Structure
project_root/
-│-- docker-compose.yml
-│-- kafka_producer/
-│   │-- producer.py
-│   │-- requirements.txt
-│-- flink_pipeline/
-│   │-- src/main/java/com/fraina/
-│   │   │-- operators/
-│   │   │   │-- FilteringFunction.java
-│   │   │   │-- FeatureExtractionFunction.java
-│   │   │   │-- AnomalyDetectionFunction.java
-│   │   │   │-- AlertFunction.java
-│   │   │-- sources/
-│   │   │   │-- KafkaTransactionSource.java
-│   │   │-- utils/
-│   │   │   │-- Constants.java
-│   │   │   │-- UtilityFunctions.java
-│   │   │   │-- ConfigLoader.java
-│   │   │-- pipeline/
-│   │   │   │-- FraudDetectionPipeline.java
-│   │   │-- interfaces/
-│   │   │   │-- TransactionProcessor.java
-│   │-- src/main/resources/
-│   │   │-- application.yaml
-│   │-- pom.xml
-│-- README.md

## Local SetUp
## **1️⃣ Running Docker Compose**
Ensure Docker is installed, then run:
```bash
docker compose up -d
```
This starts **Kafka & Zookeeper**.

## **2️⃣ Running Kafka Producer**
Navigate to the producer directory:
```bash
cd kafka_producer
pip install -r requirements.txt  # Install dependencies
python producer.py  # Start producing transactions
```

## **3️⃣ Running Flink Pipeline**
Build the Flink project:
```bash
cd flink_pipeline
mvn clean package
```
Run the pipeline:
```bash
flink run -c com.fraina.pipeline.FraudDetectionPipeline target/flink-fraud-detection-1.0-SNAPSHOT.jar
```

### Data Ingestion
- Stream real-time transaction data from **Apache Kafka**.
## **Understanding Flink Components Used**
This Flink pipeline is composed of the following key components:

### **KafkaTransactionSource**
- Reads real-time financial transactions from **Kafka**.
- Uses `FlinkKafkaConsumer` to connect and consume data from the specified topic.

### **FilteringFunction**
- Filters out low-risk transactions.
- Ensures only transactions exceeding a certain threshold are processed further.

### **FeatureExtractionFunction**
- Extracts key fraud detection features from raw transactions.
- Examples: frequency of transactions, unusual transaction amounts, or location anomalies.

### **AnomalyDetectionFunction**
- Detects fraudulent transactions using rule-based checks or ML-based approaches.
- Can be extended to integrate **Spark ML models** for more accurate fraud detection.

### **AlertFunction**
- Generates alerts when suspicious transactions are detected.
- These alerts can be sent to a monitoring system like **Redis**, **Cassandra**, or **Grafana**.

### **FraudDetectionPipeline**
- Assembles all components into a **Flink data stream processing pipeline**.
- Reads from Kafka → Filters transactions → Extracts features → Detects fraud → Triggers alerts.
- Runs as a **Flink streaming job** that continuously processes data in real time.

### Machine Learning
- **Spark MLlib** for fraud detection models (Random Forest, Logistic Regression).
- Model training with historical data and real-time adaptation.

### Batch Processing
- **Apache Spark** for aggregating historical transaction data for model training and periodic updates.

### Storage
- **Redis** for quick lookups.
- **Cassandra/PostgreSQL** for long-term storage.

### Visualization & Monitoring
- **Grafana/Kibana** dashboard for real-time monitoring.
- **Prometheus** for performance metrics and alerting.

### Architecture Diagram
<img width="1152" alt="image" src="https://github.com/user-attachments/assets/138bb1d0-e3d6-47f7-a9b2-c8508cd94e7e" />


## Contributing
Contributions are welcome! Feel free to open issues, suggest features, or submit pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

