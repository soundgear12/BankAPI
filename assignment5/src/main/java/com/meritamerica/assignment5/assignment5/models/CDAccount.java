package com.meritamerica.assignment5.assignment5.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {

    private final CDOfferings offering;

    public CDAccount(CDOfferings offering, double balance) {
        super(balance, offering.getInterestRate(), new Date());
        this.offering = offering;
    }

    private CDAccount(long accountNumber, double balance, double interestRate, int term, Date date) {
        super(accountNumber, balance, interestRate, date);
        this.offering = new CDOfferings(term, interestRate);
    }
    
    

    public int getTerm() { return this.offering.getTerm(); }

    

    public double futureValue(){ return super.futureValue(this.offering.getTerm()); }

    

    @Override
    public boolean deposit(double amount) { return false; }

    @Override
    public boolean withdraw(double amount) { return false; }


}