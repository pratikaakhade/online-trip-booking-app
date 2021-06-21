package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Payment;
import com.yrrhelp.entities.Places;
import com.yrrhelp.repositories.PlaceRepo;
import com.yrrhelp.services.PlaceService;

@RestController
@RequestMapping("/pl")
public class PlaceController {
	@Autowired
	PlaceService ps;
	
	
	@GetMapping("/showpl")
	public List<Places> getAllPlaces() {
		
		return ps.getAllPlaces();
	}
	
	@PostMapping("/addpplace/{packid}")
	public Places addPlace(@RequestBody Places p,@PathVariable Integer packid ) {
		return ps.addPlaces(p,packid);
		
	}
	
	
	@GetMapping("/placesin/{loc}")
	public List<Places> showallPlacesByPackage(@PathVariable("loc") Integer loc)
	{
		List<Places> m= ps.getPlacesinpackage(loc);
		return m;
	}
	
	
	
}
