package com.company;

public class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Transaction: " + type + " - Amount: " + amount;
    }
}