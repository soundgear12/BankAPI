package com.meritamerica.assignment5.assignment5.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.meritamerica.assignment5.assignment5.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment5.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.assignment5.models.CDAccount;
import com.meritamerica.assignment5.assignment5.models.CheckingAccount;
import com.meritamerica.assignment5.assignment5.models.MeritBank;
import com.meritamerica.assignment5.assignment5.models.SavingsAccount;

@RestController
public class AccountHolderController {
	List<AccountHolder> accountholders = new ArrayList<AccountHolder>();
	List<CheckingAccount> checkingaccounts = new ArrayList<CheckingAccount>();

	// AccountHolder
	@GetMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getaccountholder() {
		return MeritBank.getAccountHolders();
	}
	
	
	@PostMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addaccountholder(@RequestBody @Valid AccountHolder ach) {	
		MeritBank.addaccountholder(ach);
		return ach;
	}
	

	
	@GetMapping(value = "/AccountHolder/{id}")
	public AccountHolder getPostById(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = MeritBank.getaccountHolder(id);
		if (ach == null) {
			throw new NoSuchResourceFoundException("Invalid id");
		}	
		return ach;
	}
	
	
	//CheckingAccount
	@PostMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount chk) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		ach.addCheckingAccount(chk);
		return chk;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CheckingAccount[] getCheckingAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		return ach.getCheckingAccounts();
	}
	
	
	//SavingsAccount
	@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody @Valid SavingsAccount svg) throws NoSuchResourceFoundException {
		//checkingaccounts.add(checkingAccount);
		AccountHolder ach = getPostById(id);
		ach.addSavingsAccount(svg);
		return svg;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public SavingsAccount[] getSavingsAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		return ach.getSavingsAccounts();
	}
	
	
	//CDAccounts
	@PostMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody @Valid CDAccount cda) throws NoSuchResourceFoundException {
		//checkingaccounts.add(checkingAccount);
		AccountHolder ach = getPostById(id);
		ach.addCDAccount(cda);
		return cda;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CDAccount[] getCDAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		return ach.getCdAccounts();
	}
	
}
