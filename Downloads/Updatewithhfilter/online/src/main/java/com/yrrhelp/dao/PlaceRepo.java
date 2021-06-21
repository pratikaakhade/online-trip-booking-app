package com.yrrhelp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Hotel;
import com.yrrhelp.entities.Places;
@Repository
public interface PlaceRepo extends CrudRepository<Places, Integer> {
	List<Places> findByPackageID(Integer loc);
}
