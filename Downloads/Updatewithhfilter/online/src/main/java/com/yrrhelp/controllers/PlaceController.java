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

import com.yrrhelp.dao.PlaceRepo;
import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Payment;
import com.yrrhelp.entities.Places;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.PlaceException;
import com.yrrhelp.services.PlaceService;

@RestController
@RequestMapping("/pl")
@CrossOrigin("*")
public class PlaceController {
	@Autowired
	PlaceService ps;

	@GetMapping("/showpl")
	public List<Places> getAll() {
		try {
			return ps.getAllPlaces();
		} catch (PlaceException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get Place", e);
		}
	}

	@PostMapping("/addpplace")
	public Places add(@RequestBody Places p) {
		try {
			return ps.addPlaces(p);
		} catch (PlaceException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get Place", e);

		}

	}

	@GetMapping("/placesin/{loc}")
	public List<Places> showallbyloc(@PathVariable("loc") Integer loc) {
		try {
			List<Places> m = ps.getPlacesinpackage(loc);
			return m;
		} catch (PlaceException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get Place", e);

		}

	}

}
