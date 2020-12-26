package com.rs.us.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CITY_MASTER")
@Data
public class City {
	@Id
	@Column(name="CITY_ID")
	private Integer id;
	@Column(name="CITY_NAME")
	private String name;
	@Column(name="STATE_ID")
	private Integer stateId;

}
