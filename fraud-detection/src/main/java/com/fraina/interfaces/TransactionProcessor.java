package com.fraina.interfaces;

/**
 * Interface for transaction processing.
 */
public interface TransactionProcessor {
    void processTransaction(String transactionJson);
}