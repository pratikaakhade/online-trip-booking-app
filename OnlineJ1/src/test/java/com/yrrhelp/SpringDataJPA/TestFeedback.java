package com.yrrhelp.SpringDataJPA;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.catalina.core.ApplicationContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yrrhelp.entities.Customer;
import com.yrrhelp.entities.Feedback;
import com.yrrhelp.exception.FeedbackException;
import com.yrrhelp.repositories.CustomerRepo;
import com.yrrhelp.repositories.FeedbackRepo;
import com.yrrhelp.services.CustomerService;
import com.yrrhelp.services.FeedbackService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFeedback {
	
 

	@Autowired
	private FeedbackService feedService;

	@MockBean
	private FeedbackRepo feedRepo;

	@Test
	public void getallFeedbackTest() throws FeedbackException {
		Feedback fe=new Feedback();
		fe.setBookingID(1);
		fe.setComments("good");
		fe.setFeedbackID(2300);
		fe.setPackageID(2500);
		fe.setRating(5);
		
		Feedback fe1=new Feedback();
		fe1.setBookingID(2);
		fe1.setComments("good12");
		fe1.setFeedbackID(225);
		fe1.setPackageID(215);
		fe1.setRating(4);
		List<Feedback> Feedbacklist = new ArrayList<>();
		Feedbacklist.add(fe);
		Feedbacklist.add(fe1);
		


		Mockito.when(feedRepo.findAll()).thenReturn(Feedbacklist);
		assertThat(feedService.getallFeedback()).isEqualTo(Feedbacklist);
		
		}
	
	@Test
	public void addFeedbackTest() {
		Feedback fe2=new Feedback();
		fe2.setBookingID(2);
		fe2.setComments("good");
		fe2.setFeedbackID(2300);
		fe2.setPackageID(2500);
		fe2.setRating(5);
		
		Mockito.when(feedRepo.save(fe2)).thenReturn(fe2);
		assertThat(feedService.addFeedback(fe2)).isEqualTo(fe2);
	}
	
//	@Test
//	public void getbybookingidTest() {
//		
//			Feedback fe=new Feedback();
//			fe.setBookingID(1);
//			fe.setComments("good");
//			fe.setFeedbackID(2300);
//			fe.setPackageID(2500);
//			fe.setRating(5);
//			
//			Feedback fe1=new Feedback();
//			fe1.setBookingID(2);
//			fe1.setComments("good12");
//			fe1.setFeedbackID(225);
//			fe1.setPackageID(215);
//			fe1.setRating(4);
//			List<Feedback> Feedbacklist = new ArrayList<>();
//			Feedbacklist.add(fe);
//			Feedbacklist.add(fe1);
//			
//
//
//			Mockito.when(feedRepo.getfeedback(fe.getBookingID())).thenReturn(Feedbacklist);
//			assertThat(feedService.).isEqualTo(Feedbacklist);
//			
//			}
		
	
	}
