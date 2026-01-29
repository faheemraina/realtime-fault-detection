package com.fraina.operators;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.json.JSONObject;

/**
 * Generates alerts for detected fraudulent transactions.
 */
public class AlertFunction extends RichMapFunction<String, String> {
    @Override
    public String map(String transactionJson) {
        JSONObject transaction = new JSONObject(transactionJson);
        return "ALERT: Potential fraud detected for transaction " + transaction.getLong("transaction_id");
    }
}