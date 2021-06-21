package com.meritamerica.assignment5.assignment5.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {

    private CDOfferings cdOffering;

    public CDAccount(CDOfferings offering, double balance) {
        super(balance, offering.getInterestRate(), new Date());
        this.cdOffering = offering;
    }

    private CDAccount(long accountNumber, double balance, double interestRate, int term, Date date) {
        super(accountNumber, balance, interestRate, date);
        this.cdOffering = new CDOfferings(term, interestRate);
    }
    
    public CDAccount() {
    	super();
    }
    

    public CDOfferings getCdOffering() {
		return cdOffering;
	}

	public void setCdOffering(CDOfferings offering) {
		this.cdOffering = offering;
	}

	//public int getTerm() { return this.cdOffering.getTerm(); }

    

   // public double futureValue(){ return super.futureValue(this.cdOffering.getTerm()); }

    

    @Override
    public boolean deposit(double amount) { return false; }

    @Override
    public boolean withdraw(double amount) { return false; }


}