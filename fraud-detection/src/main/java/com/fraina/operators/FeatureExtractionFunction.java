package com.fraina.operators;

import org.apache.flink.api.common.functions.MapFunction;
import org.json.JSONObject;

/**
 * Extracts features from transaction data for fraud detection.
 */
public class FeatureExtractionFunction implements MapFunction<String, String> {
    @Override
    public String map(String transactionJson) {
        JSONObject transaction = new JSONObject(transactionJson);
        transaction.put("risk_score", Math.random() * 100); // Placeholder for real scoring logic
        return transaction.toString();
    }
}