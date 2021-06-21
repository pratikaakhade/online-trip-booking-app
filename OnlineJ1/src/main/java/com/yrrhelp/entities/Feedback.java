package com.yrrhelp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity class, @Entity and @Id are mandatory annotations

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
//If the @Table annotation is ignored, then class name will be the table name
//@Table(name = "Feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackID;
	private Integer bookingID;
	private String comments;
	private Integer rating;
	private Integer packageID;
}