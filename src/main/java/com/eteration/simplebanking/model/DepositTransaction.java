package com.eteration.simplebanking.model;


import java.time.LocalDate;

public class DepositTransaction extends Transaction {

    public DepositTransaction(double amount) {
        super(amount);
    }

    public void execute(Account account){

        account.deposit(this.getAmount());
        setDate(LocalDate.now());
    }

}
