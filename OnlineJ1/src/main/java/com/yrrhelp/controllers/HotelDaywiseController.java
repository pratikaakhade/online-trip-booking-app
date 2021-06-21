package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.HotelDaywise;
import com.yrrhelp.services.HotelDaywiseService;

@RestController
@RequestMapping("/hotelD")
public class HotelDaywiseController {

	@Autowired
	HotelDaywiseService hoteldd;
	
	@GetMapping("/showhotelDay")
	public List<HotelDaywise> showallHoteldaywise()
	{
		return hoteldd.getallHoteldaywise();
	}
	
//	@PostMapping("/addhoteld/{booking_id}/{place1}/{hotel}/{place2}/{hotel2}/{place3}/{hotel3}")
//	public HotelDaywise addcuss(@PathVariable Integer booking_id,@PathVariable 	Integer place1,
//			@PathVariable Integer hotel,@PathVariable Integer place2,@PathVariable Integer hotel2,@PathVariable Integer place3,@PathVariable Integer hotel3)
//	{
//		
//		HotelDaywise g= hoteldd.addHotelDaywise(new HotelDaywise(place1,booking_id));
//		HotelDaywise h= hoteldd.addHotelDaywise(new HotelDaywise(place2,booking_id));
//		HotelDaywise i= hoteldd.addHotelDaywise(new HotelDaywise(place3,booking_id));
//		return g;
//	}
	@GetMapping("/rent/{i}")
	public Integer getRentByBookingId(@PathVariable Integer i)
	{
		Integer p = hoteldd.sumofrent(i);
		return p;
	}
	
}

