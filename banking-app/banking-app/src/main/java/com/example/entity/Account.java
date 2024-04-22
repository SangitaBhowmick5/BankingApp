package com.example.entity;


import jakarta.persistence.*;


@Entity
@Table(name ="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "acc_hol_name")
    private String accHolderName;
    private double balance;

    public Account() {
    }

    public Account(Long id, String accHolderName, double balance) {
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
}
