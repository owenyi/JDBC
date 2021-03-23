package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 1. 서버와 연결하기 위해서 먼저 Driver를 메모리에 로드
 * 2. 디비 서버와 연결하기...연결에 성공하면 Connection 객체가 반환된다.
 * 3. PreparedStatement를 반환받는다. 2번에서 생성된 connection이 그 기능을 갖고있다.
 * 4. 3번에서 생성된 PreparedStatement의 기능...executeQuery()를 이용해서 SQL문을 실행한다.
 */
public class DBConnectionTest1 {
	
	public DBConnectionTest1() {
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); // ClassNotFoundException
			System.out.println("Driver Loading Success!!");
			
			// 2. 디비 서버와 연결
			String url ="jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "root", "1234"); // SQLException
			System.out.println("DB Server Connection...OK!!");
			
			// 3. PreparedStatement 생성...psmt or ps
			String sql = "SELECT * FROM myscott";
			PreparedStatement ps = conn.prepareStatement(sql); // SQLException
			System.out.println("PreparedStatement...Creating");
			
			// 4. SQL문 실행...executeQuery();...java.sql의 ResultSet
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + ", " + rs.getInt(2) + ", " + rs.getDate(3));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail!!");
		} catch (SQLException e) {
			System.out.println("DB Server Connection...Fail!!");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new DBConnectionTest1();
		

	}

}
