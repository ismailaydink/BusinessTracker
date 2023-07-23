package com.sabanciuniv.applications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.model.Food;
import com.sabanciuniv.repo.FoodRepo;

@RestController
@RequestMapping("/getFoods")
public class getFoods {
	
	@Autowired private FoodRepo foodrepo;
	
	
	@GetMapping("/getFoods")
	public List<Food> getfoods(){
		
		return foodrepo.findAll();
		
	}

}
