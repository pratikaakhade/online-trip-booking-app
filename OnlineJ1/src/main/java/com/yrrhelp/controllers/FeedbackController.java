package com.yrrhelp.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yrrhelp.entities.Feedback;
import com.yrrhelp.services.FeedbackService;
@RestController
@RequestMapping("/feedback")


public class FeedbackController {
	@Autowired
	FeedbackService feedsrv;

	@GetMapping("/showfeedback")
	public List <Feedback>showallfeedback(){
		return feedsrv.getallFeedback();
	}
	@PostMapping("/addfeedback")
	public Feedback addfeedback(@RequestBody Feedback FeedBack) {
		FeedBack = feedsrv.addFeedback(FeedBack);
		return FeedBack ;
	
	}
	@GetMapping("/feedbackk/{i}")
	public List<Feedback> showFeedbackByBookingId(@PathVariable Integer i)
	{
		List<Feedback> f = feedsrv.getbybookingid(i);
		return f;
	}
	@GetMapping("/avgrating/{i}")
	public Float getAvgRatingByPackage(@PathVariable Integer i)
	{
		Float e = feedsrv.getavgrating(i);
		return e;
	}
}