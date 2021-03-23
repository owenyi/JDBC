package com.encore.exception;

public class InvalidInputException extends Exception {

	public InvalidInputException() {
		this("Max must be larger than Min...");
	}
	public InvalidInputException(String message) {
		super(message);
	}
	
	
}
