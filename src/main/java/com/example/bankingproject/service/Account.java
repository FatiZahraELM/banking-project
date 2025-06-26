package com.example.bankingproject.service;

import com.example.bankingproject.entity.Transaction;
import com.example.bankingproject.enums.TransactionType;
import com.example.bankingproject.exception.InsufficientBalanceException;
import com.example.bankingproject.exception.InvalidTransactionException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Account implements AccountService {
    List<Transaction> transactionList = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        if(amount<0){
            throw  new InvalidTransactionException("The deposit amount must be greater than zero.");
        }
        Transaction transaction ;
        int balance = 0;
        if (!transactionList.isEmpty()) {
            transaction = transactionList.get(transactionList.size() - 1);
            balance = transaction.getBalance() + amount;
        }
        else{
            balance+=amount;
        }

        transactionList.add(new Transaction(amount, new Date(), balance, TransactionType.DEPOSIT));
    }

    @Override
    public void withdraw(int amount) {
        if(amount<0){
            throw  new InvalidTransactionException("The withdraw amount must be greater than zero.");
        }

        Transaction transaction ;
        int balance=0;
        if(!transactionList.isEmpty()){
         transaction = transactionList.get(transactionList.size() - 1);
        if (transaction.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient funds to complete this withdrawal.");
        }
         balance = transaction.getBalance() - amount;
        }
        else {
            throw new RuntimeException("Withdraw impossible account empty");

        }
        transactionList.add(new Transaction(amount, new Date(), balance, TransactionType.WITHDRAW));

    }

    @Override
    public void printStatement() {
        List<Transaction> reversedTransactions = new ArrayList<>(transactionList);
        Collections.reverse(reversedTransactions);
        System.out.println(" Date    || Amount   || Balance");

        for (Transaction t : reversedTransactions) {
            String sign = t.getTransactionType() == TransactionType.WITHDRAW ? "-" : "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(t.getDate()) + "    || " + sign + t.getAmount() + "    || " + t.getBalance());
        }
    }
}
