package com.meritamerica.assignment5.assignment5.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(double openingBalance) { super(openingBalance, 0.0001, new Date()); }

    private CheckingAccount(long accountNumber, double balance, double interestRate, Date date) {
        super(accountNumber, balance, interestRate, date);
    }
    

   
}