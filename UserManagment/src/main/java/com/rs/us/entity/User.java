package com.rs.us.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USER_MASTER")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer id;
	@Column(name = "FNAME")
	private String firstname;
	@Column(name = "LNAME")
	private String lastname;
	@Column(name = "EMAIL",unique=true)
	private String email;
	@Column(name = "PHNO")
	private String phone;
	@Column(name = "DOB")
	private LocalDate dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "COUNTRY")
	private Integer country;
	@Column(name = "STATE")
	private Integer state;
	@Column(name = "CITY")
	private Integer city;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ACC_STATUS")
	private String acc_status;

}
