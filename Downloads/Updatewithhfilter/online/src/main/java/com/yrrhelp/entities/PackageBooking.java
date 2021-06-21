
package com.yrrhelp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
//@Table(name = "PackageBooking")
public class PackageBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingID;
	private Integer customerID;
	private Integer packageID;
	private Date bookingDate;	
	private Date tripStartDate;
	private Date tripEndDate;
}
