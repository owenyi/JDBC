package com.encore.exception;

public class BookNotFoundException extends Exception {

	public BookNotFoundException() {
		this("Book not found...");
	}
	public BookNotFoundException(String message) {
		super(message);
	}

}
