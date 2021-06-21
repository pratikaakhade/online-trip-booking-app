package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.repositories.CustomerRepo;
@Service
public class CustomerService {
	@Autowired
	CustomerRepo cus;
	//database-> java 0-> website
	public List<Customer> getallCustomer() {
		
		List<Customer> customerlist = new ArrayList<>();
		cus.findAll().forEach(customerlist::add);
		return customerlist;
	}
	//websitebody -> java -> database
	public Customer addCustomer(Customer c) {
		Customer f= cus.save(c);
		return f;
		
	}
	
	
	
}
