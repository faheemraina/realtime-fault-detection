# Real-time Financial Transaction Streaming with Kafka and Apache Storm

## Overview
This project simulates a real-time financial transaction pipeline using Apache Kafka and Apache Storm.

## Project Structure
```
project_root/
│-- docker-compose.yml  # Kafka and Zookeeper setup
│-- kafka_producer/
│   │-- producer.py  # Kafka producer generating transaction data
│   │-- requirements.txt  # Python dependencies
│-- README.md  # Documentation
```

## Setup Instructions

### Prerequisites
- Docker & Docker Compose
- Python 3.x
- Apache Kafka (if running outside Docker)

### Running Kafka and Zookeeper
```bash
docker-compose up -d
```

### Creating Kafka Topic
```bash
docker exec -it kafka kafka-topics.sh --create --topic transactions --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
```

### Installing Dependencies
```bash
pip install -r kafka_producer/requirements.txt
```

### Running Kafka Producer
```bash
python kafka_producer/producer.py
```

## Next Steps
- Implement a Storm topology to process real-time transactions.
- Integrate fraud detection using Apache Spark ML.
- Store data in Redis/Cassandra for real-time lookups.
- Visualize transaction patterns using Grafana/Kibana.