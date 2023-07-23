package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("myadmin")
public class Admin {

	@Id
	private String id;
	
	private String username;
	private String password;
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}


	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
