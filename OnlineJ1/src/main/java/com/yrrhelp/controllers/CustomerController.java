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

import com.yrrhelp.entities.Customer;
import com.yrrhelp.services.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cus")
public class CustomerController {

	@Autowired
	CustomerService cusm;
	
	@GetMapping("/showcustomer")
	@ApiOperation(value="Retriving all hotel day wise details")
	public List<Customer> showAllCustomer()
	{
		return cusm.getallCustomer();
	}
	
	@PostMapping("/addcustomer")
	public Customer AddCustomer(@RequestBody Customer c)
	{
		c = cusm.addCustomer(c);
		return c;
	}
	
}
