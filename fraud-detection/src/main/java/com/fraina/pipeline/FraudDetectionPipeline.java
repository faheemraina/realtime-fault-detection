package com.fraina.pipeline;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import com.fraina.sources.KafkaTransactionSource;
import com.fraina.operators.FilteringFunction;
import com.fraina.operators.FeatureExtractionFunction;
import com.fraina.operators.AnomalyDetectionFunction;
import com.fraina.operators.AlertFunction;

/**
 * Fraud Detection Pipeline for processing transactions in real-time using Flink.
 */
public class FraudDetectionPipeline {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Read transactions from Kafka
        DataStream<String> transactions = env.addSource(KafkaTransactionSource.createSource());

        // Process the transactions through the pipeline
        DataStream<String> filteredTransactions = transactions.filter(new FilteringFunction());
        DataStream<String> extractedFeatures = filteredTransactions.map(new FeatureExtractionFunction());
        DataStream<String> detectedAnomalies = extractedFeatures.filter(new AnomalyDetectionFunction());
        detectedAnomalies.map(new AlertFunction()).print();

        // Execute the pipeline
        env.execute("Fraud Detection Pipeline");
    }
}