# kafka_producer/producer.py
from kafka import KafkaProducer
import json
import random
import time
from datetime import datetime

# Kafka configuration
KAFKA_TOPIC = "transactions"
KAFKA_BROKER = "localhost:9092"

# Create a Kafka producer
producer = KafkaProducer(
    bootstrap_servers=KAFKA_BROKER,
    value_serializer=lambda v: json.dumps(v).encode("utf-8"),
)

# Simulate financial transactions
def generate_transaction():
    return {
        "transaction_id": random.randint(100000, 999999),
        "user_id": random.randint(1, 1000),
        "amount": round(random.uniform(5, 5000), 2),
        "currency": random.choice(["USD", "EUR", "GBP", "INR", "JPY"]),
        "timestamp": datetime.utcnow().isoformat(),
        "location": random.choice(["USA", "UK", "India", "Germany", "Japan", "Canada"]),
        "device": random.choice(["Web", "Mobile", "POS Terminal"]),
        "merchant_id": random.randint(1, 500),
    }

# Continuously send transactions
print("Producing transaction messages...")
while True:
    transaction = generate_transaction()
    producer.send(KAFKA_TOPIC, value=transaction)
    print(f"Sent: {transaction}")
    time.sleep(random.uniform(0.5, 2))  # Simulate transaction rate