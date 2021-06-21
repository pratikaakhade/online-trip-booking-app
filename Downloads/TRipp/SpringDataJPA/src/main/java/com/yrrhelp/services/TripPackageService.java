package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.yrrhelp.entities.Customer;
//import com.yrrhelp.entities.Product;
import com.yrrhelp.entities.TripPackage;
//import com.yrrhelp.repositories.CustomerRepo;
import com.yrrhelp.repositories.TripPackageRepo;
@Service
public class TripPackageService {
	@Autowired
	TripPackageRepo trip;
	//database-> java 0-> website
	public List<TripPackage> getallTripPackage() {
		
		List<TripPackage> packageList = new ArrayList<>();
		trip.findAll().forEach(packageList::add);
		return packageList;
	}
	//websitebody -> java -> database
	public TripPackage addTripPackage(TripPackage t) {
		TripPackage tp= trip.save(t);
		return tp;
		
	}
	
	

}
