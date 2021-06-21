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
import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Places;
import com.yrrhelp.exception.HotelException;
import com.yrrhelp.services.CustomerService;
import com.yrrhelp.services.HotelService;
import com.yrrhelp.services.PackageBookingService;
import com.yrrhelp.services.PlaceService;

@RestController
@RequestMapping("/htlrp")
@CrossOrigin("*")
public class HotelController {

	@Autowired
	HotelService htlsrv;
	@Autowired
	PlaceService p;

	@GetMapping("/showhtlrp")
	public List<Hotel> showallhtlrp() {
		try {
			return htlsrv.getAllHotel();
		} catch (HotelException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get hotel", e);

		}

	}

	@PostMapping("/addhtlrp")
	public Hotel addhtl(@RequestBody Hotel hotel) {
		try {
			hotel = htlsrv.addHotel(hotel);
			return hotel;
		} catch (HotelException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get hotel", e);
		}
	}

	@GetMapping("/loc/{loc}")
	public List<Hotel> showallbyloc(@PathVariable("loc") String loc) {
		try {
			List<Hotel> m = htlsrv.getHotel(loc);
			return m;
		} catch (HotelException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get hotel", e);
		}
		
	}

	@GetMapping("/loc/{loc}/{rent}")
	public List<Hotel> showallbyloc(@PathVariable("loc") String loc, @PathVariable("rent") Integer rent) {
		try {
			List<Hotel> m = htlsrv.getHotelAndRent(loc, rent);
			return m;
		} catch (HotelException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get hotel", e);
		}
		
	}
}
