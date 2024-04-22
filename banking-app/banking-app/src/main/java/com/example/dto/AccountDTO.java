package com.example.dto;

import lombok.Data;

public class AccountDTO {
    private Long id;
    private String accHolderName;

    public AccountDTO(Long id, String accHolderName, double balance) {
        this.id=id;
        this.accHolderName=accHolderName;
        this.balance=balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;
}
