package com.encore.test;

import java.sql.SQLException;

import com.encore.dao.impl.BookDAOImpl;
import com.encore.exception.BookNotFoundException;
import com.encore.exception.DuplicateISBNException;
import com.encore.exception.InvalidInputException;
import com.encore.vo.Book;

import config.ServerInfo;

public class BookDAOTest {

	public static void main(String[] args) throws SQLException{

		BookDAOImpl dao = BookDAOImpl.getInstance();
//		try {
//			dao.registerBook(new Book("8H8", "자율주행2", "로드만", "encore", 34000));
//			System.out.println("책 등록 성공");
//		} catch (Exception e) {
//			System.out.println("책 등록 실패");
//		}
		
//		try {
//			dao.deleteBook("8H8");
//		} catch (Exception e) {
//			
//		}
		
//		try {
//			for (Book b : dao.findByWriter("나가타")) {
//				System.out.println(b);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			for (Book b: dao.findByPrice(10000, 20000))
//				System.out.println(b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			dao.discountBook(00, "동아");
			dao.printAllInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("드라이버 로딩 성공~~!!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~!!");
		}
	}

}
