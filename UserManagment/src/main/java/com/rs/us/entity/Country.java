package com.rs.us.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="COUNTRY_MASTER")
@Data
public class Country {
	@Id
	@Column(name="COUNTRY_ID")
	private Integer id;
	@Column(name="COUNTRY_NAME")
	private String name;

}
