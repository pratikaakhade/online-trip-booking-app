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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.services.CustomerService;

@RestController
@RequestMapping("/cus")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	CustomerService cusm;

	@GetMapping("/showcus")
	public List<Customer> showallcus() {
		try {
			return cusm.getallCustomer();

		} catch (CustomerException e) {
			throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get customer", e);
		}

	}

	@PostMapping("/addcus")
	public Customer addcuss(@RequestBody Customer c) {
		try {
			c = cusm.addCustomer(c);
			return c;	
		} catch (CustomerException e) {
			throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add customer", e);
		}

	}

}
