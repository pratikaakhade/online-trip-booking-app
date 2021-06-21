package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.HotelRepo;
import com.yrrhelp.entities.Hotel;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.HotelException;

@Service

public class HotelService {
	@Autowired
	HotelRepo htlrp;

	public List<Hotel> getAllHotel() throws HotelException {
		try {
			List<Hotel> hotelList = new ArrayList<>();
			htlrp.findAll().forEach(hotelList::add);
			return hotelList;

		} catch (DataAccessException e) {
			throw new HotelException(e.getMessage(), e);
		}
	}

	public Hotel addHotel(Hotel hotel) throws HotelException {
		try {
			Hotel h = htlrp.save(hotel);
			return h;
		} catch (DataAccessException e) {
			throw new HotelException(e.getMessage(), e);
		}

	}

	public List<Hotel> getHotel(String loc) throws HotelException {
		try {
			List<Hotel> hotelList = new ArrayList<>();
			htlrp.findByLocation(loc).forEach(hotelList::add);
			return hotelList;
		} catch (DataAccessException e) {
			throw new HotelException(e.getMessage(), e);
		}

	}

	public List<Hotel> getHotelAndRent(String loc, Integer rent) throws HotelException {
		try {
			List<Hotel> hotelList = new ArrayList<>();
			htlrp.findByLocationAndRent(loc, rent).forEach(hotelList::add);
			return hotelList;
		} catch (DataAccessException e) {
			throw new HotelException(e.getMessage(), e);
		}

	}
}
