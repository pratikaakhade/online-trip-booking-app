package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.HotelDaywise;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.HotelDaywiseException;
import com.yrrhelp.services.HotelDaywiseService;

@RestController
@RequestMapping("/hotelD")
@CrossOrigin("*")
public class HotelDaywiseController {

	@Autowired
	HotelDaywiseService hoteldd;

	@GetMapping("/showhotelDay")
	public List<HotelDaywise> showallHoteldaywise() {
		try {
			return hoteldd.getallHoteldaywise();
		} catch (HotelDaywiseException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get HotelDaywise", e);
		}

	}

	@PostMapping("/addhoteld/{booking_id}/{place1}/{hotel1}/{place2}/{hotel2}/[place3}/{hotel3}")
	public HotelDaywise addcuss(@PathVariable Integer booking_id, @PathVariable Integer place1,
			@PathVariable String place2, @PathVariable String place3, @PathVariable Integer hotel1,
			@PathVariable Integer hotel2, @PathVariable Integer hotel3) {
		try {
			HotelDaywise g = hoteldd.addHotelDaywise(new HotelDaywise(1, hotel1, place1, booking_id));
			return g;
		} catch (HotelDaywiseException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get HotelDaywise", e);
		}

	}

}
