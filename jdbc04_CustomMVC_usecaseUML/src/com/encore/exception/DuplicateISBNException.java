package com.encore.exception;

public class DuplicateISBNException extends Exception {

	public DuplicateISBNException() {
		this("Duplicated ISBN...");
	}
	public DuplicateISBNException(String message) {
		super(message);
	}
	
}
