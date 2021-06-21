package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.HotelDayRepo;
import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.HotelDaywise;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.HotelDaywiseException;

@Service
public class HotelDaywiseService {
	@Autowired
	HotelDayRepo hotelday;

	// database-> java 0-> website
	public List<HotelDaywise> getallHoteldaywise() throws HotelDaywiseException {
		try {
			List<HotelDaywise> hoteldaywiselist = new ArrayList<>();
			hotelday.findAll().forEach(hoteldaywiselist::add);
			return hoteldaywiselist;
		} catch (DataAccessException e) {
			throw new HotelDaywiseException(e.getMessage(), e);
		}

	}

	// websitebody -> java -> database
	public HotelDaywise addHotelDaywise(HotelDaywise h) throws HotelDaywiseException {
		try {
			HotelDaywise p = hotelday.save(h);
			return p;
		} catch (DataAccessException e) {
			throw new HotelDaywiseException(e.getMessage(), e);
		}

	}

}