package com.yrrhelp.entities;

import java.util.List;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import javax.persistence.Table;

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
//@Table(name = "TripPackage")
public class TripPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageID;
	private String destination;
	private Integer cost;
	private Integer No_of_day;
	@OneToMany(mappedBy = "tripPackage",fetch=FetchType.LAZY)
	private List<Places> place;
	public TripPackage(Integer packageID, String destination, Integer cost, Integer no_of_day) {
		super();
		this.packageID = packageID;
		this.destination = destination;
		this.cost = cost;
		No_of_day = no_of_day;
	}
}