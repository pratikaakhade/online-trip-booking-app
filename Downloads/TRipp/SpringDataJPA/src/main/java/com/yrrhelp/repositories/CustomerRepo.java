package com.yrrhelp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Customer;
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
