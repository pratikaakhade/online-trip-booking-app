package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.repositories.CustomerRepo;
@Service
public class CustomerService {
	@Autowired
	CustomerRepo cus;
	//database-> java 0-> website

	// database-> java 0-> website
	public List<Customer> getallCustomer() throws CustomerException {
		try {
			//throw new NullPointerException();
			List<Customer> customerlist = new ArrayList<>();
			cus.findAll().forEach(customerlist::add);
			return customerlist;
		} catch (DataAccessException e ) {
			throw new CustomerException(e.getMessage(), e);
//		}catch(NullPointerException e) {
//			throw new CustomerException(e.getMessage(), e);
		}
	}

	// websitebody -> java -> database
	public Customer addCustomer(Customer c) throws CustomerException {
		try {
			Customer f = cus.save(c);
			return f;
		} catch (DataAccessException e) {
			throw new CustomerException(e.getMessage(), e);
		}

	}

	}
	
	
	

