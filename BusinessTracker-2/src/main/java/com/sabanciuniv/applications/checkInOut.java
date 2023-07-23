package com.sabanciuniv.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.BusinessTracker2Application;
import com.sabanciuniv.model.User;
import com.sabanciuniv.repo.UserRepo;


@RestController
@RequestMapping("/check")
public class checkInOut {

	@Autowired private UserRepo userrepo;
	
	@GetMapping("/checkIn/{id}")
	public String checkIn(@PathVariable("id") String id){
		
		if(BusinessTracker2Application.logIn == false) {
			
			
			return "Please log in";
		}
		
		if (userrepo.findById(id).isEmpty()) {
			
			return "User doesn't exist";
		}
		
		
		User user = userrepo.findById(id).get();
		
		
		userrepo.delete(user);
		
		user.checkIn();
		
		userrepo.insert(user);
		
		return user.getName() + " checked in at : " + user.getCheckInTime();
		
		
	}
	
	
	@GetMapping("/checkOut/{id}")
	public String checkOut(@PathVariable("id") String id) {
		
		if(BusinessTracker2Application.logIn == false) {
			
			
			return "Please log in";
		}
		if (userrepo.findById(id).isEmpty()) {
			
			return "User doesn't exist";
		}

		User user = userrepo.findById(id).get();
		
		userrepo.delete(user);
		
		String message = user.checkOut();
		
		userrepo.insert(user);
		
		return message;
		
		
		
		
	}
	
	
	
	
	
}
