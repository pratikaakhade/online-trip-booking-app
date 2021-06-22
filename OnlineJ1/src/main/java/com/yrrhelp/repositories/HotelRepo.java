package com.yrrhelp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Hotel;
@Repository

public interface HotelRepo extends CrudRepository <Hotel,Integer>{
	List<Hotel> findByLocation(String name);
//	@Query
//	("from Hotel h, Places p where h.location ==?1 and p.location == ?1")
//	List<Hotel> getHotelbyLocation(String location);
//	List<Hotel> getHotelbyPackageID(Integer packID);
	
	@Query("SELECT h FROM Hotel h WHERE h.location = ?1 AND h.hotelrent<=?2")
	List<Hotel> findByLocationAndRent(String location, Integer hotelrent);

}
