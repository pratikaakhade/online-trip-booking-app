package com.yrrhelp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
//@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentID;
	private Integer amount;
	private String paymentType;
	private String status;
	private Date paymentDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bookingID")
    private PackageBooking packageBooking;
	}