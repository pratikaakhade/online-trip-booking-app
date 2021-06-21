package com.yrrhelp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.HotelDaywise;
@Repository
public interface HotelDayRepo extends CrudRepository<HotelDaywise, Integer> {

}

