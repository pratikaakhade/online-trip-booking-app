package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Payment;
import com.yrrhelp.entities.Places;
import com.yrrhelp.entities.TripPackage;
import com.yrrhelp.repositories.PlaceRepo;
import com.yrrhelp.repositories.TripPackageRepo;

@Service
public class PlaceService {

	@Autowired
	PlaceRepo pr;
	@Autowired
	TripPackageRepo tp;

	public List<Places> getAllPlaces() {

		List<Places> p = new ArrayList<>();
		pr.findAll().forEach(p::add);
		return p;
	}
	public Places addPlaces(Places p, Integer packid) {
		TripPackage t = tp.findById(packid).get();
		p.setTripPackage(t);
		p = pr.save(p);
		return p;
	}
	public List<Places> getPlacesinpackage(Integer loc) {
		List<Places> p = new ArrayList<>();
//		pr.findByPackageId(loc).forEach(p::add);
		p=tp.findById(loc).get().getPlace();
		
		return p;
	}
	

}
