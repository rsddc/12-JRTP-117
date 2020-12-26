package com.rs.us.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="STATE_MASTER")
@Data
public class State {
	@Id
	@Column(name="STATE_ID")
	private Integer id;
	@Column(name="STATE_NAME")
	private String name;
	@Column(name="COUNTRY_ID")
	private Integer countryId;

}
