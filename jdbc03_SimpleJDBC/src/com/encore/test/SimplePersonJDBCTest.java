package com.encore.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.vo.Person;

import config.ServerInfo;

/*
 * DAO + Test
 * JDBC 5단계(드라이버 로딩은 제외)
 * 2. 디비연결
 * 3. PreparedStatement 생성
 * 4. 쿼리문 실행 및 바인딩
 * 5. 자원 닫기
 * ---> 이중에서
 * 메소드마다 고정적으로 바뀌지 않고 로직이 작성되는 부분은 2와 5번이다.
 * 이런 부분은 메소드를 새롭게 정의하고
 * 메소드마다 호출해서 재사용하는 방법으로 로직을 다시 작성해야한다.
 */
public class SimplePersonJDBCTest {
	
	// 1.
	public SimplePersonJDBCTest() throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER);
		System.out.println("Driver Loading...");
	}
	
	// 2.
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("디비 서버 연결...");
		return conn;
	}

	// 5.
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	public void addPerson(Person p) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = getConnect();

		String query = "INSERT INTO person VALUES (?, ?, ?)";
		ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement 객체 생성");
		
		ps.setInt(1, p.getSsn());
		ps.setString(2, p.getName());
		ps.setString(3, p.getAddress());
		
		System.out.println(ps.executeUpdate() + "명 추가되었습니다.");
		
		closeAll(ps, conn);
	}
	
	// 위의 함수화된 2, 5 안쓰고 원본으로 남겨둠.
	public void deletePerson(int ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("디비 서버 연결...");

		String query = "DELETE FROM person WHERE ssn=?";
		ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement 객체 생성");
		
		ps.setInt(1, ssn);
		
		System.out.println(ps.executeUpdate() + "명 삭제되었습니다.");
		
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	
	public void updatePerson(Person p) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = getConnect();

		String query = "UPDATE person SET name=?, address=? WHERE ssn=?";
		ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement 객체 생성");
		
		ps.setString(1, p.getName());
		ps.setString(2, p.getAddress());
		ps.setInt(3, p.getSsn());
		
		System.out.println(ps.executeUpdate() + "명 수정되었습니다.");
		
		closeAll(ps, conn);
	}
	
	// SELECT... conn, ps, rs...close()?
	public ArrayList<Person> findAllPerson() throws SQLException {
		ArrayList<Person> list = new ArrayList<Person>();
		
		PreparedStatement ps = null;
		Connection conn = getConnect();

		String query = "SELECT ssn, name, address FROM person";
		ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement 객체 생성");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			list.add(new Person(
					rs.getInt("ssn"), 
					rs.getString("name"), 
					rs.getString("address")
					));
		}
		
		closeAll(rs, ps, conn);
		
		return list;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, Exception {

		SimplePersonJDBCTest jdbc = new SimplePersonJDBCTest();
//		jdbc.addPerson(new Person(222, "Jane", "Texas"));
//		jdbc.deletePerson(222);
//		jdbc.addPerson(new Person(333, "Tomas", "Canada"));
//		jdbc.updatePerson(new Person(333, "Tomas", "Brandon"));
		System.out.println(jdbc.findAllPerson());
		
	}

}
