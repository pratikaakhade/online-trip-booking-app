package com.yrrhelp.SpringDataJPA;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.catalina.core.ApplicationContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.repositories.CustomerRepo;
import com.yrrhelp.services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomer {

 

	@Autowired
	private CustomerService cusService;

	@MockBean
	private CustomerRepo cusRepo;

	@Test
	public void getallCustomerTest() throws CustomerException {
		Customer cc=new Customer();
		cc.setCustomer_ID(17);
		cc.setEmail_ID("dbjdbcjhd@ccndc");
		cc.setFullname("vishal");
		cc.setPassword("admin");
		cc.setUser_type("customer");


		Customer cc2=new Customer();
		cc2.setCustomer_ID(18);
		cc2.setEmail_ID("vishd@ccndc");
		cc2.setFullname("kalpesh");
		cc2.setPassword("mohit");
		cc2.setUser_type("admin");

		List<Customer> customerlist = new ArrayList<>();
		customerlist.add(cc);
		customerlist.add(cc2);

		Mockito.when(cusRepo.findAll()).thenReturn(customerlist);
		assertThat(cusService.getallCustomer()).isEqualTo(customerlist);
		
		}
	@Test
	public void addCustomerTest() throws CustomerException {
		Customer cc=new Customer();
		cc.setCustomer_ID(17);
		cc.setEmail_ID("dbjdbcjhd@ccndc");
		cc.setFullname("vishal");
		cc.setPassword("admin");
		cc.setUser_type("customer");
		
		Mockito.when(cusRepo.save(cc)).thenReturn(cc);
		assertThat(cusService.addCustomer(cc)).isEqualTo(cc);
		
	}



}
