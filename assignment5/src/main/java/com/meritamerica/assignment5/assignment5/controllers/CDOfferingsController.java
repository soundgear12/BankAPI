package com.meritamerica.assignment5.assignment5.controllers;

import java.util.ArrayList;
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

import com.meritamerica.assignment5.assignment5.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment5.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.assignment5.models.CDOfferings;
import com.meritamerica.assignment5.assignment5.models.MeritBank;



@RestController
public class CDOfferingsController {
	
	ArrayList<CDOfferings> cdOfferings = new ArrayList<CDOfferings>();
	
	
	@GetMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOfferings> getcdOfferings(){
		return MeritBank.getCDOfferings();
	}
	
	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOfferings addcdOfferings(@RequestBody @Valid CDOfferings cdOffering) {	
		MeritBank.addCDO(cdOffering);
		return cdOffering;
	}
	
	@GetMapping(value = "/CDOfferings/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CDOfferings getPostById(@PathVariable int id) throws NoSuchResourceFoundException {
		CDOfferings cdo = MeritBank.getCDOfferings(id);
		if (cdo == null) {
			throw new NoSuchResourceFoundException("Invalid id");
		}	
		return cdo;
	}
	
	
}