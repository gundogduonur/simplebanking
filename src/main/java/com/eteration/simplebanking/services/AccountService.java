package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountService {

    // private final Map<String, Account> accounts;

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /*public Account findAccount(String accountNumber) {
        assert accounts != null;
        return accounts.get(accountNumber);
    }*/
    public Account findAccount(String accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        return account.orElse(null);
    }


}
