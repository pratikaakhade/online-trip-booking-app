package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.HotelDaywise;
import com.yrrhelp.entities.PackageBooking;
import com.yrrhelp.repositories.BookingRepo;
import com.yrrhelp.repositories.HotelDayRepo;
@Service
public class HotelDaywiseService {
	@Autowired
	HotelDayRepo hotelday;
	@Autowired
	BookingRepo bk;
	//database-> java 0-> website
	public List<HotelDaywise> getallHoteldaywise() {
		
		List<HotelDaywise> hoteldaywiselist = new ArrayList<>();
		hotelday.findAll().forEach(hoteldaywiselist::add);
		return hoteldaywiselist;
	}
	//websitebody -> java -> database
	public HotelDaywise addHotelDaywise(HotelDaywise h) {
		HotelDaywise p= hotelday.save(h);
		return p;
		
	}
	public Integer sumofrent(Integer i)
	{
		 PackageBooking p= bk.findById(i).get();
		Integer d= p.getHoteldaywise().stream().map(o->o.getHotel().getHotelrent()).reduce(Integer::sum).get();
		return d;
	}
	
	

}