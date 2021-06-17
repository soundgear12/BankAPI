package com.meritamerica.assignment5.assignment5.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(double openingBalance) { super(openingBalance, 0.01, new Date()); }

    private SavingsAccount(long accountNumber, double balance, double interestRate, Date date) {
        super(accountNumber, balance, interestRate, date);
    }

    
}