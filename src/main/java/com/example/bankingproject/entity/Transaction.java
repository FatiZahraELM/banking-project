package com.example.bankingproject.entity;

import com.example.bankingproject.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private int amount;
    private Date date;
    private int balance;

    private TransactionType transactionType;
    public Transaction(int amount, Date date, int balance,TransactionType transactionType) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
        this.transactionType=transactionType;
    }

    public Transaction() {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
