package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Places;
import com.yrrhelp.exception.HotelException;
import com.yrrhelp.repositories.HotelRepo;
import com.yrrhelp.repositories.PlaceRepo;
import com.yrrhelp.repositories.TripPackageRepo;
@Service

public class HotelService {
	@Autowired
	HotelRepo htlrp;
	@Autowired
	TripPackageRepo trip;
	@Autowired
	PlaceRepo p;
	public List<Hotel> getAllHotel() {
		List<Hotel> hotelList = new ArrayList<>();
		htlrp.findAll().forEach(hotelList::add);
		return hotelList;
	}	

	public Hotel addHotel(Hotel hotel, Integer placeid){
		Places pl = p.findById(placeid).get();
		hotel.setPlace(pl);
		
		Hotel h = htlrp.save(hotel);
		return h;
	}
		public List<Hotel> getHotel(String loc) {
		List<Hotel> hotelList = new ArrayList<>();
		htlrp.findByLocation(loc).forEach(hotelList::add);
		return hotelList;
	}
//		public List<Hotel> getbyloc(String loc)
//		{
//			List<Hotel> h = htlrp.getHotelbyLocation(loc);
//			return h;
//		}
		public List<Hotel> getallbyloc(Integer loc)
		{
			List<Hotel> h = new ArrayList<>();
					List<Places> p= trip.findById(loc).get().getPlace();
					
					for (Places places : p) {
					h.addAll(places.getHotel());
					}
			return h;
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

//		public Hotel addHotel(Hotel hotel, Integer placeid) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
}





