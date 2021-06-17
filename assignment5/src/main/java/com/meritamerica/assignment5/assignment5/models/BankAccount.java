package com.meritamerica.assignment5.assignment5.models;

import java.text.ParseException;
import java.util.*;

public abstract class BankAccount {

    // region instance variables
	int id;
	int nextId = 1;
    private final Date accountOpenedOn;
    private final Long accountNumber;
    private final double interestRate;
    private double balance;
 
    // endregion

    // region constructors
    BankAccount(double balance, double interestRate){
        this(MeritBank.getNextAccountNumber(), balance, interestRate, new Date());
    }

    BankAccount(double balance, double interestRate, Date accountOpenedOn){
        this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
    }

    protected BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn){
        this.id = nextId++;
    	this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountOpenedOn = accountOpenedOn;
    }
    // endregion

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// region getters/setters
    public long getAccountNumber() { return this.accountNumber; }

    public double getBalance() { return this.balance; }

    public double getInterestRate() { return this.interestRate; }

    public Date getOpenedOn() { return this.accountOpenedOn; }

    public boolean withdraw(double amount){
        if (this.balance - amount < 0) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    public boolean deposit (double amount){
        if (amount < 0) {
            return false;
        } else {
            this.balance += amount;
            return true;
        }
    }



 
    // endregion

    // region read/write from string
   

    

   
}