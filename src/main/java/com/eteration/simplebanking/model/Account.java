package com.eteration.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    private String owner;
    private String accountNumber;
    private double balance;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
    public Account() {
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }



    public void post(Transaction transaction) throws InsufficientBalanceException {
         transaction.setDate(LocalDate.now());
         transaction.execute(this);
         transactions.add(transaction);
    }


    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        balance += amount;
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
}
