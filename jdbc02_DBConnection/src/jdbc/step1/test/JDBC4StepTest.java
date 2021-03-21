package jdbc.step1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 디비 Access 하기 위한 4단계 작업을 작성하는 로직..
 * 1. 디비 서버에 대한 파편적인 정보들을 상수로 지정
 */
public class JDBC4StepTest {
	
	public static String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static String URL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static String USER = "root";
	public static String PASSWORD = "1234";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(DRIVER);
		System.out.println("1. 드라이버 로딩 성공..");
		
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("2. 디비 연결 성공..");
		
//		String query = "INSERT INTO mytable (num, name, address) VALUES (?, ?, ?)"; // 이 때 값이 들어가지는 않는다!
//		PreparedStatement ps = conn.prepareStatement(query);
//		System.out.println("3. PreparedStatement 생성..");
//		
//		ps.setInt(1, 333);
//		ps.setString(2, "박나래");
//		ps.setString(3, "여의도");
//		
//		int row = ps.executeUpdate();
//		System.out.println(row + "row insert...OK");
//		
//		String querydel = "DELETE FROM mytable WHERE num=?";
//		PreparedStatement ps1 = conn.prepareStatement(querydel);
//		System.out.println("3. PreparedStatement 생성..");
//		
//		ps1.setInt(1, 333);
//		System.out.println(ps1.executeUpdate() + " row delete...OK");
//		
//		String queryUpdate = "UPDATE mytable SET name=?, address=? WHERE num=?";
//		PreparedStatement ps2 = conn.prepareStatement(queryUpdate);
//		System.out.println("3. PreparedStatement 생성..");
//		
//		ps2.setString(1, "정우제");
//		ps2.setString(2, "방배동");
//		ps2.setInt(3, 111);
//		System.out.println(ps2.executeUpdate() + " row update...OK");
		
		String querySelect = "SELECT num, name, address FROM mytable";
		PreparedStatement ps3 = conn.prepareStatement(querySelect);
		System.out.println("3. PreparedStatement 생성..");
		
		ResultSet rs = ps3.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("num") + "\t"
							   + rs.getString("name") +"\t"
							   + rs.getString("address"));
		}

	}

}
