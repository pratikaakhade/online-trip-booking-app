package com.yrrhelp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Hotel;
@Repository

public interface HotelRepo extends CrudRepository <Hotel,Integer>{
	List<Hotel> findByLocation(String name);
	
	@Query("SELECT h FROM Hotel h WHERE h.location = ?1 AND h.hotelrent<=?2")
	List<Hotel> findByLocationAndRent(String location, Integer hotelrent);

}
