package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Admin;

public interface AdminRepo extends MongoRepository<Admin, String> {

	List<Admin> findByUsername(String username);
	
}
