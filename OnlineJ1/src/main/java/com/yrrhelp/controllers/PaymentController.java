package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrrhelp.entities.Payment;
import com.yrrhelp.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/refund")
	public List<Payment> getAllPayments() {
		
		return paymentService.getAllPayments();
	}
	
	@PostMapping("/addpay")
	public Payment addPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}
	
}
