package jdbc.step3.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

/*
 * 디비 Access 하기 위한 4단계 작업을 작성하는 로직..
 * 1. 디비 서버에 대한 파편적인 정보들을 상수로 지정
 * --> 문제점 : 소스 코드에 서버 정보가 그대로 노출되어 있다.
 * 해결책 :메타데이터화 시키자
 * 2. 상수 값과 추상 메소드를 구성 요소로 갖는 인터페이스를 별도의 모듈로 생성하고
 *    그 안에 서버 정보를 메타데이터화 시킨다.
 *    
 * 3. 자바 진영에서 가장 많이 사용하는 Meta Data는 properties파일이다.
 * Key - Value 값을 모두 스트링으로 저장할 수 있다는 특징에 착안되어져
 * 서버 정보를 저장하는 메타데이터로 가장 많이 사용되어진다.
 * config < db.properties
 */
public class JDBC4StepTest {

	static String driver;
	static String url;
	static String user;
	static String pass;
	static String query;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		System.out.println("1. 드라이버 로딩 성공..");
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("2. 디비 연결 성공..");
		
		String querySelect = query;
		PreparedStatement ps3 = conn.prepareStatement(querySelect);
		System.out.println("3. PreparedStatement 생성..");
		
		ResultSet rs = ps3.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("num") + "\t"
							   + rs.getString("name") +"\t"
							   + rs.getString("address"));
		}

	}
	
	static {
		// 1. properties 파일의 내용을 로드해온다.
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			
			driver = p.getProperty("jdbc.mysql.driver");
			url = p.getProperty("jdbc.mysql.url");
			user = p.getProperty("jdbc.mysql.user");
			pass = p.getProperty("jdbc.mysql.pass");
			query = p.getProperty("jdbc.sql.selectAll");
		} catch (IOException e) {
			
		}
	}

}
