package com.retailservice.product.exception;

import java.util.Date;

public class ExceptionMessage {
	
	private String message;
	private String description;
	private Date timeStamp;
	
	public ExceptionMessage(String message, String description, Date timeStamp) {
		super();
		this.message = message;
		this.description = description;
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
