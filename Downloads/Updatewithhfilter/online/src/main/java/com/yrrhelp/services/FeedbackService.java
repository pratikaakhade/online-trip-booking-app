package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yrrhelp.dao.FeedbackRepo;
import com.yrrhelp.entities.Feedback;
import com.yrrhelp.exception.CustomerException;
import com.yrrhelp.exception.FeedbackException;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepo feed;

	// database-> java 0-> website
	public List<Feedback> getallFeedback() throws FeedbackException {
		try {
			List<Feedback> Feedbacklist = new ArrayList<>();
			feed.findAll().forEach(Feedbacklist::add);
			return Feedbacklist;
		} catch (DataAccessException e) {
			throw new FeedbackException(e.getMessage(), e);
		}

	}

	// websitebody -> java -> database
	public Feedback addFeedback(Feedback f) throws FeedbackException {
		try {
			Feedback F = feed.save(f);
			return F;
		} catch (DataAccessException e) {
			throw new FeedbackException(e.getMessage(), e);

		}

	}

}