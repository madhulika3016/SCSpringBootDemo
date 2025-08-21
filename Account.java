package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SavingAccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int accountId;
    @Column(unique = true, nullable = false,name="typeofaccount")
    String accountType;
    double balance;

    public Account() {
    }
    public Account(int accountId, String accountType, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
