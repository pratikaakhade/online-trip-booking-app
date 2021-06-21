package com.yrrhelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yrrhelp.entities.PackageBooking;
import com.yrrhelp.services.PackageBookingService;
@RestController
@RequestMapping("/book")

public class PackageBookingController {

	@Autowired
	PackageBookingService packagebook;
	
	@GetMapping("/showbook")
	public List<PackageBooking> showAllPackageBook()
	{
		return packagebook.getallPackageBooking();
	}
	
	@PostMapping("/addbook")
	public PackageBooking addPackageBook(@RequestBody PackageBooking pb)
	{
		pb = packagebook.addBooking(pb);
		return pb;
	}
	@PostMapping("/cancelbooking/{i}")
	public void cancelBooking(@PathVariable Integer i)
	{
		packagebook.deletebooking(i);
	}
	@GetMapping("/s")
	public String showallpackagebook1()
	{
		return "packagebook.getallPackageBooking()";
	}

}