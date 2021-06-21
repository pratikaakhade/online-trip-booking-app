package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.PlaceRepo;
import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Payment;
import com.yrrhelp.entities.Places;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.PlaceException;

@Service
public class PlaceService {

	@Autowired
	PlaceRepo pr;

	public List<Places> getAllPlaces() throws PlaceException {
		try {
			List<Places> p = new ArrayList<>();
			pr.findAll().forEach(p::add);
			return p;
		} catch (DataAccessException e) {
			throw new PlaceException(e.getMessage(), e);
		}

	}

	public Places addPlaces(Places p) throws PlaceException {
		try {
			p = pr.save(p);
			return p;
		} catch (DataAccessException e) {
			throw new PlaceException(e.getMessage(), e);
			}
		
	}

	public List<Places> getPlacesinpackage(Integer loc) throws PlaceException {
		try {
			List<Places> p = new ArrayList<>();
			pr.findByPackageID(loc).forEach(p::add);
			return p;
		} catch (DataAccessException e) {
			throw new PlaceException(e.getMessage(), e);
			}
		
	}

}
