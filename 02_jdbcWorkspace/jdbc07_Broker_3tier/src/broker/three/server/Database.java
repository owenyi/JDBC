package broker.three.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.vo.CustomerRec;
import broker.three.vo.SharesRec;
import broker.three.vo.StockRec;
import config.ServerInfo;

/*
 * 싱글톤 사용 X
 */
public class Database implements DatabaseTemplate {
	
	public Database(String serverIp) throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER);
		System.out.println("드라이버 로딩 성공...");
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Server Connection...");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) ps.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null) rs.close();
		closeAll(ps, conn);
	}

	/// ssn이 있는지 없는지 확인하는 기능...하나 추가...isIsbn()과 동일한 기능
	public boolean isExist(String ssn, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 3.
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		ps = conn.prepareStatement(query);
		
		// 4.
		ps.setString(1, ssn);
		rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 2.
			conn = getConnect();
			if (!isExist(cust.getSsn(), conn)) {
				// 3.
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES (?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				// 4.
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				System.out.println(ps.executeUpdate() + "명 ADD OK...addCustomer()...");
			} else {
				throw new DuplicateSSNException();
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	// delete에 portfolio 지우는 내용이 포함되어야한다...외래키 지정을 제약조건에 추가하면 shares에서 ssn에 해당하는 레코드가 자동으로 삭제된다.
	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 2.
			conn = getConnect();
			
			// 3.
			String query = "DELETE FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			// 4.
			ps.setString(1, ssn);
			int row = ps.executeUpdate();
			if (row == 0) throw new RecordNotFoundException();
			else System.out.println(row + "명 DELETE OK...deleteCustomer()...");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 2.
			conn = getConnect();
			
			// 3.
			String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			// 4.
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getSsn());
			int row = ps.executeUpdate();
			if (row == 0) throw new RecordNotFoundException();
			else System.out.println(row + "명 UPDATE OK...updateCustomer()...");
		} finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<SharesRec> v = new Vector<SharesRec>();
		try {
			conn = getConnect();
			
			// ssn에 해당하는 고객이 없는 경우는 고려하지 않는가?
			String query = "SELECT ssn, symbol, quantity FROM shares WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			while (rs.next()) {
				v.add(new SharesRec(
						ssn, 
						rs.getString("symbol"), 
						rs.getInt("quantity")
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return v;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cust = null;
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			if (rs.next()) {
				cust = new CustomerRec( // getPortfolio를 먼저 만들어야하는 이유
						ssn, 
						rs.getString("cust_name"), 
						rs.getString("address"),
						getPortfolio(ssn) // * 이렇게 해도 되고
						);
			} // 없으면 안 가져오면 되기 때문에 else는 안 한다.
//			cust.setPortfolio(getPortfolio(ssn)); // * 이렇게 해도 된다.
		} finally {
			closeAll(rs, ps, conn);
		}
		return cust;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, cust_name, address FROM customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CustomerRec(
						rs.getString("ssn"), 
						rs.getString("cust_name"), 
						rs.getString("address"),
						getPortfolio(rs.getString("ssn"))
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StockRec> list = new ArrayList<StockRec>();
		try {
			conn = getConnect();
			
			String query = "SELECT symbol, price FROM stock";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new StockRec(
						rs.getString("symbol"), 
						rs.getFloat("price")
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	// 주식을 갖고 있으면 insert 0, 100 -> insert into 100
	// 주식을 안 갖고 있으면 update 50, 100 -> update 150
	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			
			String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			if (rs.next()) {
				int q = rs.getInt(1); // q는 현재 갖고 있는 주식의 수량
				int newQuantity = q + quantity; // q(0) + quantity(100) | q(50) + quantity(100)
				
				query = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, newQuantity);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
				System.out.println(ps.executeUpdate() + "row UPDATE OK...buyShares()...");
			} else { 
				query = "INSERT INTO shares (ssn, symbol, quantity) VALUES (?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				ps.setString(2, symbol);
				ps.setInt(3, quantity);
				System.out.println(ps.executeUpdate() + "row INSERT OK...buyShares()...");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	
	/*
	 * 누가 어떤 주식을 몇 개 팔 것인가에 대한 기능을 정의...
	 * 현재 갖고 있는 주식의 수량을 먼저 알아야한다...int q
	 * 경우의 수가 4가지
	 *    보유  SELL operating
	 * 1) 100  50   UPDATE
	 * 2) 100  100  DELETE
	 * 3) 100  200  InvalidTransactionException
	 * 4) x         RecordNotFoundException
	 */
	@Override
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			
			String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			if (rs.next()) {
				int q = rs.getInt(1); // 현재 가지고 있는 수량..100
				int newQuantity = q - quantity; // 팔고 남은 수량
				
				if (newQuantity == 0) { // 2) DELETE
					query = "DELETE FROM shares WHERE ssn=? AND symbol=?";
					ps = conn.prepareStatement(query);
					
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					System.out.println(ps.executeUpdate() + "row DELETE OK...sellShares()...");
				} else if (newQuantity > 0) { // 1) UPDATE
					query = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
					ps = conn.prepareStatement(query);
					
					ps.setInt(1, newQuantity);
					ps.setString(2, ssn);
					ps.setString(3, symbol);
					System.out.println(ps.executeUpdate() + "row UPDATE OK...sellShares()...");
				} else { // 3) InvalidTransactionException
					throw new InvalidTransactionException();
				}
			} else { // 4) RecordNotFoundException
				throw new RecordNotFoundException();
			}
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	
}
