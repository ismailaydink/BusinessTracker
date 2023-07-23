package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Food;

public interface FoodRepo extends MongoRepository<Food, String> {

	public List<Food> findByName(String name);
	
}
