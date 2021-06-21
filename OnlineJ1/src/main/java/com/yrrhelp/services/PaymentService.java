package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrrhelp.entities.Payment;
import com.yrrhelp.repositories.PaymentRepo;
@Service
public class PaymentService {
 
	@Autowired
	PaymentRepo paymentRepo;
	
   public List<Payment> getAllPayments() {
		
		List<Payment> paymentList = new ArrayList<>();
		paymentRepo.findAll().forEach(paymentList::add);
		return paymentList;
	}
	
	public Payment addPayment(Payment payment) {
		
		payment= paymentRepo.save(payment);
		
		return payment;
	}
	
   
}