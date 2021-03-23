package com.encore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.dao.BookDAO;
import com.encore.exception.BookNotFoundException;
import com.encore.exception.DuplicateISBNException;
import com.encore.exception.InvalidInputException;
import com.encore.vo.Book;

import config.ServerInfo;

public class BookDAOImpl implements BookDAO {
	
	
	// singleton
	private BookDAOImpl() {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("Driver Loading...");
		} catch (Exception e) {
			
		}
	}
	private static BookDAOImpl dao = new BookDAOImpl();
	public static BookDAOImpl getInstance() {
		return dao;
	}
	
	// 공통적인 로직...Connection getConnect()
	// 공통적인 로직...void closeAll()...오버로딩 2개짜리, 3개짜리
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Server Connection...");
		return conn;
	}
	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null) rs.close();
		closeAll(ps, conn);
	}

//	public int isIsbn(String isbn) throws SQLException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		try {
//			// 2.
//			conn = getConnect();
//			
//			// 3.
//			String query = "SELECT count(*) FROM book WHERE isbn=?";
//			ps = conn.prepareStatement(query);
//			
//			// 4.
//			ps.setString(1, isbn);
//			rs = ps.executeQuery();
//			if (rs.next()) return rs.getInt(1); // ??첫번째 찰럼이 isbn : String임 -> 해결 : query를 다시 보기
//			return 0;
//		} finally {
//			closeAll(rs, ps, conn);
//		}
//	}
	public boolean isIsbn(String isbn, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 3.
		String query = "SELECT isbn FROM book WHERE isbn=?";
		ps = conn.prepareStatement(query);

		// 4.
		ps.setString(1, isbn);
		rs = ps.executeQuery();
		return rs.next();
	}
	@Override
	public void registerBook(Book vo) throws SQLException, DuplicateISBNException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 2.
			conn = getConnect();
			
			if (!isIsbn(vo.getIsbn(), conn)) {
				// 3.
				String query = "INSERT INTO book VALUES (?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				// 4.
				ps.setString(1, vo.getIsbn());
				ps.setString(2, vo.getTitle());
				ps.setString(3, vo.getWriter());
				ps.setString(4, vo.getPublisher());
				ps.setInt(5, vo.getPrice());
				System.out.println(ps.executeUpdate() + "항목 추가되었습니다.");
			} else {
				throw new DuplicateISBNException();
			}			
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteBook(String isbn) throws SQLException, BookNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 2.
			conn = getConnect();
			
			// 3.
			String query = "DELETE FROM book WHERE isbn=?";
			ps = conn.prepareStatement(query);
			System.out.println("Prepared 객체 생성");
			
			// 4.
			ps.setString(1, isbn);
			int row = ps.executeUpdate();
			if (row == 0) throw new BookNotFoundException();
			else System.out.println(row + "항목 삭제되었습니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public Book findByBook(String isbn, String title) throws SQLException {
		Book book = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 2.
			conn = getConnect();
			
			// 3.
			String query = "SELECT * FROM book WHERE isbn=? AND title=?";
			ps = conn.prepareStatement(query);
			
			// 4.
			ps.setString(1, isbn);
			ps.setString(2, title);
			rs = ps.executeQuery();
			if (rs.next()) 
				book = new Book(
						rs.getString("isbn"), 
						rs.getString("title"), 
						rs.getString("author"), 
						rs.getString("publisher"), 
						rs.getInt("price")
						);
		} finally {
			closeAll(ps, conn);
		}
		
		return book;
	}

	@Override
	public ArrayList<Book> findByWriter(String writer) throws SQLException {
		ArrayList<Book> list = new ArrayList<Book>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 2.
			conn = getConnect();
			
			// 3.
			String query = "SELECT * FROM book WHERE author=?";
			ps = conn.prepareStatement(query);
			
			// 4.
			ps.setString(1, writer);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(
						rs.getString("isbn"), 
						rs.getString("title"), 
						writer, // rs.getString("author") 이렇게 할 필요가 없음
						rs.getString("publisher"), 
						rs.getInt("price")
						));
			}
		} finally {
			closeAll(ps, conn);
		}
		
		return list;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) throws SQLException {
		ArrayList<Book> list = new ArrayList<Book>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = getConnect();
		
		String query = "SELECT * FROM book WHERE publisher=?";
		ps = conn.prepareStatement(query);
		System.out.println("Prepared 객체 생성");
		
		ps.setString(1, publisher);
		rs = ps.executeQuery();
		while (rs.next()) {
			list.add(new Book(
					rs.getString("isbn"), 
					rs.getString("title"), 
					rs.getString("author"), 
					rs.getString("publisher"), 
					rs.getInt("price")
					));
		}
		
		closeAll(ps, conn);
		return list;
	}

	@Override
	public ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException {
		if (min <= 0 || min >= max) throw new InvalidInputException();
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 2.
			conn = getConnect();
			
			// 3.
			String query = "SELECT * FROM book WHERE price>=? AND price<=?";
			ps = conn.prepareStatement(query);
			System.out.println("Prepared 객체 생성");
			
			// 4.
			ps.setInt(1, min);
			ps.setInt(2, max);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Book(
						rs.getString("isbn"), 
						rs.getString("title"), 
						rs.getString("author"), 
						rs.getString("publisher"), 
						rs.getInt("price")
						));
			}
		} finally {
			closeAll(ps, conn);
		}
		
		return list;
	}

	@Override
	public void discountBook(int per, String publisher) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE book SET price=price*(1-?/100) WHERE publisher=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, per);
			ps.setString(2, publisher);
			System.out.println(ps.executeUpdate() + "항목 할인되었습니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void printAllInfo() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();

			String query = "SELECT * FROM book";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("isbn") + "\t" + rs.getString("title") + "\t" + "\t"
						+ rs.getString("author") + "\t" + rs.getString("publisher") + "\t" + rs.getInt("price"));
			}
		} finally {
			closeAll(ps, conn);
		}
	}
	
}
