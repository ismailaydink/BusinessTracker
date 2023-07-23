package com.sabanciuniv.returnclasses;

public class LogInMessage {

	
	private boolean check;
	private String message;
	
	public LogInMessage() {
		// TODO Auto-generated constructor stub
	}

	public LogInMessage(boolean check, String message) {
		super();
		this.check = check;
		this.message = message;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
