package com.encore.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.exception.BookNotFoundException;
import com.encore.exception.DuplicateISBNException;
import com.encore.exception.InvalidInputException;
import com.encore.vo.Book;

public interface BookDAO {
	
	void registerBook (Book vo) throws SQLException, DuplicateISBNException;
	void deleteBook(String isbn) throws SQLException, BookNotFoundException;
	Book findByBook(String isbn, String title) throws SQLException;
	ArrayList<Book> findByWriter(String writer) throws SQLException;
	ArrayList<Book> findByPublisher(String publisher) throws SQLException;
	
	// 가격
	ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException; 
	void discountBook(int per, String publisher) throws SQLException;
	void printAllInfo() throws SQLException;
	
}
