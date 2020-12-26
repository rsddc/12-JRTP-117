package com.rs.us.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.us.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {
	
	

}
