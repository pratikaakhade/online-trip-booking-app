package com.yrrhelp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.yrrhelp.entities.Customer;
@Repository


public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
