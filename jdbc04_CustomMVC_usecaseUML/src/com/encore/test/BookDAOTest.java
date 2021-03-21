package com.encore.test;

import java.sql.SQLException;

import com.encore.dao.impl.BookDAOImpl;
import com.encore.exception.BookNotFoundException;
import com.encore.exception.DuplicateISBNException;
import com.encore.exception.InvalidInputException;
import com.encore.vo.Book;

public class BookDAOTest {

	public static void main(String[] args) throws SQLException{

		BookDAOImpl book = BookDAOImpl.getInstance();
		
		try {
			book.registerBook(new Book("111", "개미", "베르나르", "열린책들", 12000));
		} catch (DuplicateISBNException e) {
			
		}
		
		try {
			book.deleteBook("111");
		} catch (BookNotFoundException e) {
			
		}
		
		System.out.println(book.findByBook("1A1", "강아지똥"));
		
		for (Book b : book.findByWriter("나가타")) {
			System.out.println(b);
		}
		
		for (Book b : book.findByPublisher("동아")) {
			System.out.println(b);
		}
		
		try {
			for (Book b : book.findByPrice(27000, 34000)) {
				System.out.println(b);
			}
		} catch (InvalidInputException e) {
			System.out.println(e);
		}
		
		book.discountBook(50, "동아");
		
		book.printAllInfo();
	}

}
