
package com.javaproject.service;

import com.javaproject.model.Account;
import com.javaproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    private final AccountRepository accountRepository;
    
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public Account getAccountById(long id) {
        return accountRepository.findById(id);
    }
    
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
    
    public void deleteAccountById(long id) {
        accountRepository.deleteById(id);
    }
    
    public void deleteAccountByUsername(String username) {
        accountRepository.deleteByUsername(username);
    }
    
}
