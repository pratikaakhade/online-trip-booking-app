package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.yrrhelp.entities.PackageBooking;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.PackageBookingException;
import com.yrrhelp.services.PackageBookingService;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class PackageBookingController {

	@Autowired
	PackageBookingService packagebook;

	@GetMapping("/showbook")
	public List<PackageBooking> showallpackagebook() {
		try {
			return packagebook.getallPackageBooking();
		} catch (PackageBookingException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get PackageBooking", e);
		}
	}

	@PostMapping("/addbook")
	public PackageBooking addcuss(@RequestBody PackageBooking pb) {
		try {
			pb = packagebook.addBooking(pb);
			return pb;
		} catch (PackageBookingException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get PackageBooking", e);
		}

	}

}