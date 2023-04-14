package com.eteration.simplebanking.model;


import java.time.LocalDate;

// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(double amount) {
        super(amount);
    }
    public void execute(Account account) throws InsufficientBalanceException {
        account.withdraw(this.getAmount());
        setDate(LocalDate.now());
    }

}


