package com.sabanciuniv.model;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {

	
	@Id
	private String id;
	
	private String name;
	private LocalTime checkInTime;
	private double currentBalance;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, LocalTime checkInTime, double currentBalance) {
		super();
		this.name = name;
		this.checkInTime = checkInTime;
		this.currentBalance = currentBalance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public void checkIn() {
		
		setCheckInTime(LocalTime.now());
	}
	
	public String checkOut() {
		
		double divident = LocalTime.now().toSecondOfDay() - getCheckInTime().toSecondOfDay();
		double divider = 3600;
		setCheckInTime(LocalTime.MIN);
		
		Double workTime = divident / divider;
		return "Working time of " + getName() + " is: " + String.format("%.2f", workTime) + " hours.";
		
	}
	
	
	
	
}
