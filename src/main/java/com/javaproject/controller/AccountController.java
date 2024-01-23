
package com.javaproject.controller;

import com.javaproject.model.Account;
import com.javaproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/username/{username}")
    public Account getAccountByUsername(@PathVariable String username) {
        return accountService.getAccountByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable long id) {
        accountService.deleteAccountById(id);
    }

    @DeleteMapping("/username/{username}")
    public void deleteAccountByUsername(@PathVariable String username) {
        accountService.deleteAccountByUsername(username);
    }
}
