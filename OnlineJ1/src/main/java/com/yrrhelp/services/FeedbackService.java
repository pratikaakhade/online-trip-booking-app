package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrrhelp.entities.Feedback;
import com.yrrhelp.repositories.FeedbackRepo;
@Service

public class FeedbackService {
	@Autowired
	FeedbackRepo feed;
	//database-> java 0-> website
	public List<Feedback> getallFeedback() {
		
		List<Feedback> Feedbacklist = new ArrayList<>();
		feed.findAll().forEach(Feedbacklist::add);
		return Feedbacklist;
	}
	//websitebody -> java -> database
	public Feedback addFeedback(Feedback f) {
		Feedback F= feed.save(f);
		return F;
		
	
		
	}
	public List<Feedback> getbybookingid(Integer i)
	{
		List<Feedback> f = feed.getfeedback(i);
		return f;
	}
	public Float getavgrating(Integer i)
	{
		Float r = feed.getAvgRating(i);
		return r;
	}
	

}