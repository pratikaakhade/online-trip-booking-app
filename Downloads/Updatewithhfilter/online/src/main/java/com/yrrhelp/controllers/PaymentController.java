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

import com.yrrhelp.entities.Payment;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.PaymentException;
import com.yrrhelp.services.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/refund")
	public List<Payment> getAll() {
		try {
			return paymentService.getAllPayments();
		} catch (PaymentException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get Payment", e);
		}

	}

	@PostMapping("/addpay")
	public Payment add(@RequestBody Payment payment) {
		try {
			return paymentService.addPayment(payment);
		} catch (PaymentException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get Payment", e);

		}

	}

}
