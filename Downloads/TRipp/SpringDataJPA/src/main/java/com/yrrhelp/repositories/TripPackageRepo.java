package com.yrrhelp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.TripPackage;
@Repository
public interface TripPackageRepo extends CrudRepository<TripPackage, Integer> {

}
