package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.PaymentRepo;
import com.yrrhelp.entities.Payment;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.PaymentException;

@Service
public class PaymentService {

	@Autowired
	PaymentRepo paymentRepo;

	public List<Payment> getAllPayments() throws PaymentException {
		try {
			List<Payment> paymentList = new ArrayList<>();
			paymentRepo.findAll().forEach(paymentList::add);
			return paymentList;
		} catch (DataAccessException e) {
			throw new PaymentException(e.getMessage(), e);
		}

	}

	public Payment addPayment(Payment payment) throws PaymentException {
		try {
			payment = paymentRepo.save(payment);
			return payment;
		} catch (DataAccessException e) {
			throw new PaymentException(e.getMessage(), e);
		}

	}

}