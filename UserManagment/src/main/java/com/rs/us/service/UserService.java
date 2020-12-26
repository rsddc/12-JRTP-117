package com.rs.us.service;

import java.util.Map;

import com.rs.us.entity.User;

public interface UserService {
	
	
//	public String doRegistration();direct controller will load it
	
	//http://localhost:8080/signUp--->controller will return /reg
	
	public Map<Integer,String> getCountries();
	
	public Map<Integer,String> getStates(Integer countryId);
	
	public boolean saveUser(User user);
		
	public String forgotPassword(String email);
	
	public String resetPasswordAndUnlock(String email,String temp,String password);
	
	public String loginCheck(String email,String password);

	Map<Integer, String> getCities(Integer stateId);	
		
}
