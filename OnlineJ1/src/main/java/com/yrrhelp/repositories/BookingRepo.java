package com.yrrhelp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yrrhelp.entities.PackageBooking;

public interface BookingRepo extends CrudRepository<PackageBooking, Integer>  {

}