package com.eteration.simplebanking.controller;


import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account/v1")
public class AccountController {

    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber){
        Account account = accountService.findAccount(accountNumber);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @GetMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, DepositTransaction depositTransaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        account.post(depositTransaction);
        TransactionStatus status = new TransactionStatus("OK",
                java.util.UUID.randomUUID().toString());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @GetMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        account.post(withdrawalTransaction);
        TransactionStatus status = new TransactionStatus("OK",
                java.util.UUID.randomUUID().toString());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}