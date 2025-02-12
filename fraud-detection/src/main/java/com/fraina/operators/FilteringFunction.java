package com.fraina.operators;

import org.apache.flink.api.common.functions.FilterFunction;
import org.json.JSONObject;

/**
 * FilteringFunction filters out low-risk transactions.
 */
public class FilteringFunction implements FilterFunction<String> {
    @Override
    public boolean filter(String transactionJson) {
        JSONObject transaction = new JSONObject(transactionJson);
        return transaction.getDouble("amount") > 1000; // Filtering threshold
    }
}