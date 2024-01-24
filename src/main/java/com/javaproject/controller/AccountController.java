package com.javaproject.controller;

import com.javaproject.model.Account;
import com.javaproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Endpoint to find an account by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<Account> findAccountByUserId(@PathVariable Long userId) {
        Account account = accountService.findAccountByUserId(userId);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to find an active account by user ID
    @GetMapping("/{userId}/active")
    public ResponseEntity<Account> findActiveAccountByUserId(@PathVariable Long userId) {
        Account account = accountService.findActiveAccountByUserId(userId);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to deactivate an account
    @PostMapping("/{userId}/deactivate")
    public ResponseEntity<String> deactivateAccount(@PathVariable Long userId) {
        accountService.deactivateAccount(userId);
        return new ResponseEntity<>("Account deactivated successfully", HttpStatus.OK);
    }
}