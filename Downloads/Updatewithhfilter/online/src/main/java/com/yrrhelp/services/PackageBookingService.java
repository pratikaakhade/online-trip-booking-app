package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.BookingRepo;
import com.yrrhelp.entities.PackageBooking;
import com.yrrhelp.exception.PackageBookingException;
@Service
public class PackageBookingService {

	@Autowired
	BookingRepo book;

	public List<PackageBooking> getallPackageBooking() throws PackageBookingException {
		
		List<PackageBooking> BookingList = new ArrayList<>();
		book.findAll().forEach(BookingList::add);
		return BookingList;
	}
	
	public PackageBooking addBooking(PackageBooking pb) throws PackageBookingException{
		PackageBooking packbook= book.save(pb);
		return packbook;
		
	}
	

}

