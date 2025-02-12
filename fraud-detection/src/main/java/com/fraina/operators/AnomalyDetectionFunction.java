package com.fraina.operators;

import org.apache.flink.api.common.functions.FilterFunction;
import org.json.JSONObject;

/**
 * Detects potential fraudulent transactions based on risk score.
 */
public class AnomalyDetectionFunction implements FilterFunction<String> {
    @Override
    public boolean filter(String transactionJson) {
        JSONObject transaction = new JSONObject(transactionJson);
        return transaction.getDouble("risk_score") > 75; // High-risk transactions
    }
}