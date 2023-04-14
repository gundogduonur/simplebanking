package com.eteration.simplebanking.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private String transactionType;
    @ManyToOne
    Account account;

    public Transaction(double amount){
        this.amount=amount;
        this.date=LocalDate.now();
    }


    public Transaction() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public abstract void execute(Account account) throws InsufficientBalanceException;

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", account=" + account +
                '}';
    }


}
