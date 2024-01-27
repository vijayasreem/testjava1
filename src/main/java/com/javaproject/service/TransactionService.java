package com.javaproject.service;

import com.javaproject.model.Transaction;
import com.javaproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(Long accountId, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be a positive numeric value");
        }

        Double accountBalance = transactionRepository.getAccountBalance(accountId);
        if (accountBalance == null) {
            accountBalance = 0.0;
        }

        Double newBalance = accountBalance + amount;
        transactionRepository.save(new Transaction(accountId, amount, newBalance, LocalDateTime.now()));
    }
}