package com.meritamerica.assignment5.assignment5.models;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AccountHolder {
	static int nextId = 1;

	int id;
    //region InstanceVariables
     String firstName;
     String middleName;
     String lastName;
     String ssn;
    private CheckingAccount[] checkingAccounts;
    private  SavingsAccount[] savingsAccounts;
    private  CDAccount[] cdAccounts;
    private CDOfferings[] cdOfferings;
    int numberOfCheckingAccounts = 0;
    
	int numberOfSavingsAccounts = 0;
	
	int numberOfCDAccounts = 0;

	double combinedBalance = 0;
    private final double MAX_NEW_ACCOUNT_BALANCE = 250000.0;
    //endregion

    //region Constructors
    public AccountHolder() {
    	this.id = nextId++;
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.ssn = "";
        this.checkingAccounts = new CheckingAccount[0];
		this.savingsAccounts = new SavingsAccount[0];
		this.cdAccounts = new CDAccount[0];
		this.combinedBalance = 0;
    }
    //endregion
    
  

    //region Basic Info Getters/Setters
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }
    //endregion



	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.length;
	}



	public void setNumberOfCheckingAccounts(int numberOfCheckingAccounts) {
		this.numberOfCheckingAccounts = numberOfCheckingAccounts;
	}



	public double getCheckingBalance() {
		double chkBal = 0;
		for (int i = 0; i < checkingAccounts.length; i++) {
			
			chkBal += checkingAccounts[i].getBalance();
		}
		return chkBal;
	}







	public int getNumberOfSavingsAccounts() {
		return this.savingsAccounts.length;
	}



	public void setNumberOfSavingsAccounts(int numberOfSavingsAccounts) {
		this.numberOfSavingsAccounts = numberOfSavingsAccounts;
	}



	public double getSavingsBalance() {
		double svgBal = 0;
		for (int i = 0; i < savingsAccounts.length; i++) {
			
			svgBal += savingsAccounts[i].getBalance();
		}
		return svgBal;
	}







	public int getNumberOfCDAccounts() {
		return this.cdAccounts.length;
	}



	public void setNumberOfCDAccounts(int numberOfCDAccounts) {
		this.numberOfCDAccounts = numberOfCDAccounts;
	}



	public double getCdBalance() {
		double cdaBal = 0;
		for (int i = 0; i < cdAccounts.length; i++) {
			
			cdaBal += cdAccounts[i].getBalance();
		}
		return cdaBal;
	}





	public double getCombinedBalance() {
		return combinedBalance;
	}



	public void setCombinedBalance(double combinedBalance) {
		this.combinedBalance = combinedBalance;
	}



	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}



	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
	}



	public CDAccount[] getCdAccounts() {
		return cdAccounts;
	}
	
	public CDOfferings[] getCDOfferings() {
		return cdOfferings;
	}

    
    //region CheckingAccount Methods
	public CheckingAccount addCheckingAccount(double openingBalance) {
		if (openingBalance < 0.0){
			return null;
		}
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		CheckingAccount ca = new CheckingAccount(openingBalance);
		return addCheckingAccount(ca); 
	
	}
	
	public  CheckingAccount addCheckingAccount(CheckingAccount chk) {
			CheckingAccount[] temp = Arrays.copyOf(checkingAccounts, checkingAccounts.length + 1);
			temp[temp.length - 1] = chk;
			checkingAccounts = temp;
		return chk;   
    }
	

	

	
	
	
    
	//region SavingsAccount Methods
	
	public SavingsAccount addSavingsAccount(double openingBalance) {
		if (openingBalance<0.0){
			return null;
		}
		
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		
		SavingsAccount sa = new SavingsAccount(openingBalance);
		return addSavingsAccount(sa);
	}
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
			SavingsAccount[] temp = Arrays.copyOf(savingsAccounts, savingsAccounts.length + 1);
			temp[temp.length - 1] = savingsAccount;
			savingsAccounts = temp;
		return savingsAccount;
	}
    //region CDAccount Methods
    
	public CDAccount addCDAccount(CDOfferings offering, double openingBalance) {
		if (openingBalance<0.0){
			return null;
		}
		CDAccount cda = new CDAccount(offering, openingBalance);
		return addCDAccount(cda);
	}
	public CDAccount addCDAccount(CDAccount cdAccount) { 
			CDAccount[] temp = Arrays.copyOf(cdAccounts, cdAccounts.length + 1);
			temp[temp.length - 1] = cdAccount;
			cdAccounts = temp;
		return cdAccount;
	}

    
    
    
}