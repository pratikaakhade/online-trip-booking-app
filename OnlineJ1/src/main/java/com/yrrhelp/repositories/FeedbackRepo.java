package com.yrrhelp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Feedback;
@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Integer> {
@Query(value="SELECT * from Feedback fd where fd.bookingID=?1",nativeQuery = true	)
public List<Feedback> getfeedback(Integer i);
@Query(value="SELECT AVG(rating) from Feedback fd where fd.packageID=?1",nativeQuery = true	)
public Float getAvgRating(Integer e);
}