
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//If the @Table annot	ation is ignored, then class name will be the table name
//@Table(name = "PackageBooking")
public class PackageBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingID;
	
	private Integer packageID;
	private Date bookingDate;	
	private Date tripStartDate;
	private Date tripEndDate;
	@JsonIgnore
	@OneToMany(mappedBy = "packagebooking",fetch=FetchType.LAZY)
	private List<HotelDaywise> hoteldaywise;
	@ManyToOne(cascade = CascadeType.ALL)

    @JoinColumn(name="customer_ID")
    private Customer customer;
	@OneToOne(mappedBy = "packageBooking",fetch=FetchType.LAZY)
	private Payment payment;
}
