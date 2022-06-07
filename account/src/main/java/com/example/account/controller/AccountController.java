package com.example.account.controller;


import com.example.account.constants.RestEndpoints;
import com.example.account.model.Account;
import com.example.account.model.dto.AccountDTO;
import com.example.account.model.dto.AccountRegistrationDTO;
import com.example.account.model.dto.LoginDTO;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestEndpoints.ACCOUNTS)
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(RestEndpoints.REGISTER)
    public ResponseEntity<?> save(@RequestBody AccountRegistrationDTO accountBody){
        AccountDTO account = accountService.save(accountBody);
        return ResponseEntity.ok(account);
    }

    // Authenticate a user
    @PostMapping(RestEndpoints.LOGIN)
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO credentialsBody){
        return accountService.authenticate(credentialsBody);
    }

    @GetMapping()
    public ResponseEntity<List<Account>> findAllAccounts() {
        return ResponseEntity.ok(accountService.findAllAccounts());
    }

    // Get a single account by id
    @GetMapping(RestEndpoints.BY_ID)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Account> account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }
    // Get a single account by id
    @DeleteMapping(RestEndpoints.BY_ID)
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        accountService.deleteById(id);
        return ResponseEntity.ok("Account deleted successfully !");
    }

    // Get a single account by id
    @GetMapping("{id}/preferredPaymentMethod")
    public ResponseEntity<?> findPreferredPaymentMethodById(@PathVariable Long id){
        Account account = accountService.findById(id).get();
        return ResponseEntity.ok(account.getPreferredPaymentType());
    }

}
