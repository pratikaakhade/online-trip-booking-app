package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.TripPackage;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.TripPackageException;
//import com.yrrhelp.services.CustomerService;
import com.yrrhelp.services.TripPackageService;


@RestController
@RequestMapping("/trip")
@CrossOrigin("*")
public class TripPackageController {

	@Autowired
	TripPackageService tripp;
	
	@GetMapping("/showtrip")
	public List<TripPackage> showalltrip()
	{
		try {
			return tripp.getallTripPackage();
		} catch (TripPackageException e) {
			throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get TripPackage", e);
		}
	}
	
	@PostMapping("/addtrip")
	public TripPackage addtripp(@RequestBody TripPackage t)
	{
		try {
			t = tripp.addTripPackage(t);
			return t;
		} catch (TripPackageException e) {
			throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get TripPackage", e);
		
		}
		
	}
	
}