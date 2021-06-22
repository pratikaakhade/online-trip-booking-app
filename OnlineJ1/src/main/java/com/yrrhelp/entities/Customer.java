package com.yrrhelp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
//If the @Table annotation is ignored, then class name will be the table name
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customer_ID;
	private String password;
	private String fullname;
	private String email_ID;
	private String user_type;
	@JsonIgnore
	@OneToMany(mappedBy = "customer",fetch=FetchType.LAZY)
	private List<PackageBooking> packagebooking;
	
}
