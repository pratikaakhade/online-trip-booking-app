package com.yrrhelp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Places;
import com.yrrhelp.services.CustomerService;
import com.yrrhelp.services.HotelService;
import com.yrrhelp.services.PackageBookingService;
import com.yrrhelp.services.PlaceService;
@RestController
@RequestMapping("/htlrp")

public class HotelController {

	@Autowired
	HotelService htlsrv;
	@Autowired
	PlaceService p;
	
	@GetMapping("/showhtlrp")
	public List<Hotel> showAllHotels() {
		return htlsrv.getAllHotel();
	}
	
	@PostMapping("/addhtlrp/{placeid}")
	public Hotel addhotel(@RequestBody Hotel hotel,@PathVariable Integer placeid) {
		hotel = htlsrv.addHotel(hotel,placeid);
		
		return hotel ;
	}
	@GetMapping("/loc/{loc}")
	public List<Hotel> showAllbyHotelsByLocation(@PathVariable("loc") String loc)
	{
		
		List<Hotel> m = htlsrv.getHotel(loc);
		
		return m;
	}

	

	@GetMapping("/allhotels/{packid}")
	public List<Hotel> getallhotelsbypackage(@PathVariable Integer packid)
	{
//		List<Places> pl =	p.getPlacesinpackage(packid);
//		List<Integer> placeIds =	p.getPlacesinpackage(packid).stream().map(p -> p.getPlaceID()).distinct().collect(Collectors.toList());
//		List<Hotel> h1 = htlsrv.getAllHotel();
//		List<Hotel> h2 = new ArrayList<>();
//		for()
//		
		List<Hotel> h = htlsrv.getallbyloc(packid);
		return h;
	}
}




