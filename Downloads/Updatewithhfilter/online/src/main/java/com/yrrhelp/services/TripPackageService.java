package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.TripPackageRepo;
//import com.yrrhelp.entities.Customer;
//import com.yrrhelp.entities.Product;
import com.yrrhelp.entities.TripPackage;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.TripPackageException;

@Service
public class TripPackageService {
	@Autowired
	TripPackageRepo trip;

	// database-> java 0-> website
	public List<TripPackage> getallTripPackage() throws TripPackageException {
		try {
			List<TripPackage> packageList = new ArrayList<>();
			trip.findAll().forEach(packageList::add);
			return packageList;
		} catch (DataAccessException e) {
			throw new TripPackageException(e.getMessage(), e);
		}

	}

	// websitebody -> java -> database
	public TripPackage addTripPackage(TripPackage t) throws TripPackageException {
		try {

		} catch (DataAccessException e) {
			throw new TripPackageException(e.getMessage(), e);
		}
		TripPackage tp = trip.save(t);
		return tp;
	}
}