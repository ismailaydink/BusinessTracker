package com.sabanciuniv.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.BusinessTracker2Application;
import com.sabanciuniv.model.Admin;
import com.sabanciuniv.repo.AdminRepo;

@RestController
@RequestMapping("/login")
public class LogIn {
	
	@Autowired AdminRepo adminrepo;
	
	
	@GetMapping("/login/{username}/{password}")
	public String logIn(@PathVariable("username") String username,@PathVariable("password") String password) {
		
		if (adminrepo.findByUsername(username).isEmpty()) {
			
			return "User doesn't exists";
			
		}
		
		Admin admin = adminrepo.findByUsername(username).get(0);
		
		if(admin.getPassword().equals(password)) {
			
			BusinessTracker2Application.logIn = true;
			return " Hello " + admin.getUsername()+", login succesful.";
		}
		
		return "Wrong password";
		
		
	}
	
	@GetMapping("/logout")
	public String logOut() {
		
		if(BusinessTracker2Application.logIn == false) {
			
			return "You didn't logged in";
			
		}
		
		
		else {
			
			BusinessTracker2Application.logIn = false;
			return "Logout is succesful.";
			
			
		}
		
	}

	
	
	
}
