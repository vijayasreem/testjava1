package com.javaproject.service;

import com.javaproject.model.Account;
import com.javaproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Method to find an account by user ID
    public Account findAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    // Method to find an active account by user ID
    public Account findActiveAccountByUserId(Long userId) {
        return accountRepository.findByUserIdAndActiveTrue(userId);
    }

    // Method to deactivate an account
    public void deactivateAccount(Long userId) {
        accountRepository.deactivateAccount(userId);
    }
}