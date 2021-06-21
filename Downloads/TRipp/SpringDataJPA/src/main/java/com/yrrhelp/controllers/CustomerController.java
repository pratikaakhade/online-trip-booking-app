package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrrhelp.entities.Product;
import com.yrrhelp.entities.Customer;
import com.yrrhelp.services.CustomerService;

@RestController
@RequestMapping("/cus")
public class CustomerController {

	@Autowired
	CustomerService cusm;
	
	@GetMapping("/showcus")
	public List<Customer> showallcus()
	{
		return cusm.getallCustomer();
	}
	
	@PostMapping("/addcus")
	public Customer addcuss(@RequestBody Customer c)
	{
		c = cusm.addCustomer(c);
		return c;
	}
	
}
