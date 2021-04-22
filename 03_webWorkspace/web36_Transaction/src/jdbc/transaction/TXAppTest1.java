package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXAppTest1 {

	public static void main(String[] args) throws Exception {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩...");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, "root", "1234");
		System.out.println("디비 연결 성공");
		
		// 2개의 쿼리문 작성
		String query1 = "INSERT INTO test (name, birthday) VALUES(?, ?)";
		String query2 = "SELECT num, name, birthday FROM test WHERE num=?";
		
		// 위 2개의 작업을 transaction 처리함(더 이상 쪼개질 수 없는 원자 단위로 묶음)
		// transaction 시작...
		conn.setAutoCommit(false);
		
		// 이 안에 들어오는 모든 작업은 원자성을 가진다.
		PreparedStatement ps1 = conn.prepareStatement(query1);
		ps1.setString(1, "전지현");
		ps1.setString(2, "1980-01-22");
		
		ps1.executeUpdate();
		
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 4); // 위의 쿼리까지 하면 num 3까지 있다...에러...ROLLBACK...위 부분의 전지현도 추가되지 않는다.
		ResultSet rs = ps2.executeQuery();
		
		if (!rs.next()) { // 4에 해당하는 사람이 존재하지 않는다면...
			// ROLLBACK
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 사람이 없어서 rollback합니다...전지현 추가 안됨!!!^^;;");
		} else { // 4에 해당하는 사람이 존재한다면...
			// COMMIT
			conn.commit();
			System.out.println("번호에 해당하는 사람이 있어서 commit합니다...전지현이 추가돼요!!");
		}
		
		// transaction 마무리...다시 원래대로 돌려놓음
		conn.setAutoCommit(true);
	}

}
