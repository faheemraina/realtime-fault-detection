# Real-time Fraud Detection in Financial Transactions

## Overview
This project implements a **real-time fraud detection system** using **Apache Storm** to process streaming financial transactions and detect anomalies. It also leverages **Apache Spark** for batch analytics, model training, and advanced processing.

##Apache Storm?
- Real-time streaming capability makes it ideal for detecting fraud as transactions occur.
- Can be integrated with Kafka for ingestion and Redis for fast lookups.

## Key Features & Technologies

### Data Ingestion
- Stream real-time transaction data from **Apache Kafka**.

### Storm Topology
- **Spout**: Reads transactions from Kafka.
- **Filtering Bolt**: Removes low-risk transactions.
- **Feature Extraction Bolt**: Extracts key fraud indicators (e.g., transaction frequency, location changes).
- **Anomaly Detection Bolt**: Uses ML models (trained in Spark) to detect fraudulent activity.
- **Alerting Bolt**: Sends notifications for flagged transactions.

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

## Non-Trivial Aspects
- **Multiple Data Streams**: Process transactions, user behavior, and geolocation data in parallel.
- **Complex Topology**: Several interconnected bolts, each performing specialized processing.
- **Stateful Processing**: Maintain session state and detect fraud patterns over time.
- **Seamless Integration**: Apache Kafka, Redis, Spark, and Cassandra working together.

## Project Deliverables
- **Fully documented code with step-by-step instructions**
- **Docker-compose setup for easy deployment**
- **Sample Kafka producer for transaction data simulation**
- **Pre-trained ML model for fraud detection**
- **Jupyter notebooks for Spark ML training**
- **Monitoring & alerting setup with Prometheus and Grafana**

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/faheemraina/realtime-fault-detection.git
   cd real-time-fraud-detection
   ```
2. Start Kafka, Redis, and Cassandra using Docker:
   ```bash
   docker-compose up -d
   ```
3. Deploy the Apache Storm topology:
   ```bash
   storm jar target/fraud-detection-1.0.jar com.example.FraudDetectionTopology
   ```
4. Train the fraud detection model using Spark:
   ```bash
   spark-submit --class com.example.FraudModelTraining target/fraud-model.jar
   ```
5. Monitor the system in Grafana at `http://localhost:3000`

## Contributing
Contributions are welcome! Feel free to open issues, suggest features, or submit pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
This project is a solid showcase of real-time stream processing with **Apache Storm**, integrating **Apache Spark** for analytical workloads. 🚀

