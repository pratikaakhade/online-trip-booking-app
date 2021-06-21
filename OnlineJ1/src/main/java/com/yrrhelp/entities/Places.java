package com.yrrhelp.entities;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	Integer placeID;
	String place;
	
	Integer day;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="packageId")
    private TripPackage tripPackage;
	@OneToMany(mappedBy = "place",fetch=FetchType.LAZY)
	private List<Hotel> hotel;
	public Places( String place, Integer day) {
		super();
		
		this.place = place;
	
		this.day = day;
		
	}
	
}
