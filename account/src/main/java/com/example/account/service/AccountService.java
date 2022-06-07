package com.example.account.service;


import com.example.account.model.Account;
import com.example.account.model.dto.AccountDTO;
import com.example.account.model.dto.AccountRegistrationDTO;
import com.example.account.model.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    AccountDTO save(AccountRegistrationDTO accountBody);

    ResponseEntity<?> authenticate(LoginDTO credentialsBody);

    List<Account> findAllAccounts();

    Optional<Account> findById(Long id);

    void deleteById(Long id);

    Account update(Long id, Account accountBody);
}
