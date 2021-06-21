package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.TripPackage;
//import com.yrrhelp.services.CustomerService;
import com.yrrhelp.services.TripPackageService;


@RestController
@RequestMapping("/trip")
public class TripPackageController {

	@Autowired
	TripPackageService tripp;
	
	@GetMapping("/showtrip")
	public List<TripPackage> showalltrip()
	{
		return tripp.getallTripPackage();
	}
	
	@PostMapping("/addtrip")
	public TripPackage addtripp(@RequestBody TripPackage t)
	{
		t = tripp.addTripPackage(t);
		return t;
	}
	
}
