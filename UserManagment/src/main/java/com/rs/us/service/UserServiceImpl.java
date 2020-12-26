package com.rs.us.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rs.us.entity.User;
import com.rs.us.repository.CityRepository;
import com.rs.us.repository.CountryRepository;
import com.rs.us.repository.StateRepository;
import com.rs.us.repository.UserRepository;
//import com.sun.istack.NotNull;

@Service
public class UserServiceImpl implements UserService {

	public UserServiceImpl(UserRepository userRepository, CountryRepository countryRepository,
			StateRepository stateRepository,CityRepository cityRepository) {
		super();
		this.userRepository = userRepository;
		this.countryRepository = countryRepository;
		this.stateRepository = stateRepository;
		this.cityRepository = cityRepository;
	}

	private UserRepository userRepository;
	private CountryRepository countryRepository;
	private StateRepository stateRepository;
	private CityRepository cityRepository;

	@Override
	public Map<Integer, String> getCountries() {
		HashMap<Integer, String> countryMap = new HashMap<>();
		countryRepository.findAll().stream().forEach(e -> countryMap.put(e.getId(), e.getName()));
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		HashMap<Integer, String> stateMap = new HashMap<>();
		stateRepository.findByCountryId(countryId).stream().forEach(e -> stateMap.put(e.getId(), e.getName()));
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		HashMap<Integer, String> cityMap = new HashMap<>();
		cityRepository.findByStateId(stateId).stream().forEach(e -> cityMap.put(e.getId(), e.getName()));
		return cityMap;
	}

	@Override
	public boolean saveUser(User user) {

		String temp = generateTempPassword();

		user.setPassword(temp);// tempPassword till it is unlocked.
		user.setAcc_status("locked");
		if (userRepository.save(user).getId() != null) {
			sendEmail(user.getEmail());

			return true;// controller will display success msg with open email request
		}

		return false; // data will be in form. with error message.
	}
	@Override
	public String loginCheck(String email,String password) {

		 	String loginResponse="Locked";
	        User user = userRepository.findByEmailAndPassword(email,password);
	        if(user == null)loginResponse="Invalid";
	        else if("unlock".equals(user.getAcc_status()))loginResponse="valid";
	        return loginResponse;	
	}

	private void sendEmail(String email) {
		// TODO Auto-generated method stub

	}// util class

	@Override
	public String forgotPassword(String email) {//set temp password from forgot password screen and sent it from email 
		User user = userRepository.findByEmail(email);
		
		if(user != null) { //user exists or not...
			// no matter account is locked or unlocked because user object from db found. from email, user has to reset password again.
			user.setPassword(generateTempPassword());		
			sendEmail(email);
			return "sent password in the mail";
		}
		return "please register first";
	}//forgotpassword..

	@Override
	public String resetPasswordAndUnlock(String email,String tempPassword,String password) {// unlock account screen business logic

		// check temp password sent by the user from the user account screen
		// from dto pull temp password field value and get temp password stored
		// value from repository.....


		User user = userRepository.findByEmailAndPassword(email,tempPassword);
        if (user != null) {
            user.setPassword(password);
            user.setAcc_status("unlocked");
            userRepository.save(user);
            return "unlocked successfully";// controller will give sucess msg with login hyperlink
        }
        
        return "unlocked failed";

	}

	private final String generateTempPassword() {
		
		return "tempPass";
	}// util class



}
