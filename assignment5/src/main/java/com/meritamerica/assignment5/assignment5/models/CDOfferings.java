package com.meritamerica.assignment5.assignment5.models;

public class CDOfferings {
	static int nextId = 1;

	int id;

    private final int term;
    private final double interestRate;

    public CDOfferings(int term, double interestRate) {
        this.term = term;
        this.interestRate = interestRate;
    }
    
    public CDOfferings() {
		this.id = nextId++;
		this.term = 0;
		this.interestRate = 0;
	}

    public int getTerm() { return this.term; }

    public double getInterestRate() { return this.interestRate; }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

   

    public String writeToString() { return this.term + "," + this.interestRate; }


}