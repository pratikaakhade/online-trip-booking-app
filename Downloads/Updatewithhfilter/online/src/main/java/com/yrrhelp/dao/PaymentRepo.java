package com.yrrhelp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Payment;
@Repository
public interface PaymentRepo extends CrudRepository<Payment, Integer> {
	

}