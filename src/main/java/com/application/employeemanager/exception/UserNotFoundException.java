package com.application.employeemanager.exception;

import org.springframework.stereotype.Component;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message){
		super(message);
	}
}
