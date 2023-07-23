package com.sabanciuniv.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.BusinessTracker2Application;
import com.sabanciuniv.model.Food;
import com.sabanciuniv.model.User;
import com.sabanciuniv.repo.FoodRepo;
import com.sabanciuniv.repo.UserRepo;

@RestController
@RequestMapping("/eatfood")
public class EatFood {
	
	
	@Autowired UserRepo userRepo;
	@Autowired FoodRepo foodRepo;
	
	
	@GetMapping("eat/{id}/{name}")
	public String eatFood(@PathVariable("id") String id,@PathVariable("name") String name) {
		
		if(BusinessTracker2Application.logIn == false) {
			
			return "Please log in";
		}
		if (userRepo.findById(id).isEmpty()) {
			
			return "User doesn't exist";
		}
		
		
		User user = userRepo.findById(id).get();
		
		Food food = foodRepo.findByName(name).get(0);
		
		
		if(user.getCurrentBalance()<food.getCost()) {
			
			return  user.getName() + " doesn't have enough balance"; 
			
		}
		
		userRepo.delete(user);
		
		user.setCurrentBalance(user.getCurrentBalance()-food.getCost());
		
		userRepo.insert(user);
		
		return user.getName()+ " has eaten " + food.getName() + ", new balance is: " + user.getCurrentBalance();
		
	}
	
	
	@GetMapping("/addBalance/{id}/{money}")
	public String addBalance(@PathVariable("id") String id,@PathVariable("money") double balance) {
		
		
		if(BusinessTracker2Application.logIn == false) {
			
			return "Please log in";
		}
		
		
		if (userRepo.findById(id).isEmpty()) {
			
			return "User doesn't exist";
		}
		
		User user = userRepo.findById(id).get();
		
		userRepo.delete(user);
		
		user.setCurrentBalance(user.getCurrentBalance()+balance);
		
		userRepo.insert(user);
		
		
		
		
		
		
		return user.getName() + "'s balance updated. New balance is: "+ user.getCurrentBalance();
	}
	
	@GetMapping("/showBalance/{id}")
	public double showBalance(@PathVariable("id") String id) {
		
		if(BusinessTracker2Application.logIn == false) {
			
			return Double.NaN;
		}
		

		
		
		return userRepo.findById(id).get().getCurrentBalance();
	}
	
	
}
