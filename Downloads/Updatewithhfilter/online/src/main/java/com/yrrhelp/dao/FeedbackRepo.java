package com.yrrhelp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yrrhelp.entities.Feedback;
@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Integer> {

}