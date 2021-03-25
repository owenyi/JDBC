package broker.three.client;
/*
 * Database와 거의 동일한 모양으로 작성된 모듈...즉 기능의 선언부가 동일하다...하지만 구현부는 전혀 달라진다.
 * Client 사이드의 통신 알고리즘을 갖고있는 클래스...
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.vo.CustomerRec;
import broker.three.vo.SharesRec;
import broker.three.vo.StockRec;

public class Protocol {

	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	public static final int MIDDLE_PORT = 60000;

	private Command cmd; // 도시락

	public Protocol(String serverIP) throws Exception {
		s = new Socket(serverIP, MIDDLE_PORT);
		oos = new ObjectOutputStream(s.getOutputStream()); // 문자 기반이 아니기 따문에 auto flushing 필요 없음
		ois = new ObjectInputStream(s.getInputStream());
	}

	public void close() {
		try {
			s.close();
		} catch (Exception e) {
			System.out.println("Protocol close()...error..." + e);
		}
	}
	
	// 모든 메소드마다 공통적으로 반복되는 로직을 정의...
	public void writeCommand(Command cmd) { // 얘네는 private이어야 하는 게 아닌지?
		try {
			oos.writeObject(cmd);
			System.out.println("Client writeObject cmd...end");
		} catch (IOException e) {
			System.out.println("Client writeObject cmd...error " + e);
		}
	}
	public int getResponse() { // readObject + getResult().getStatus()
		try {     // ois.readObject()의 리턴 타입은 Object라 캐스팅해줘야 함
			cmd = (Command) ois.readObject(); // 응답에 대한 status이 같이 온다.
			System.out.println("Client readObject cmd...end");
		} catch (Exception e) {
			System.out.println("Client readObject cmd...error " + e);
		}// 0(성공), (-1) RecordNotFoundException, (-2) DuplicationSSNException, (-3) InvalidTransactionException
		
//		int status = cmd.getResults().getStatus();
//		return status;
		System.out.println(cmd.getResults());
		return 0;
	}
	
	// 2tier의 Broker에서 Database 메소드를 호출하고 있는데...코드 수정이 없기 위해서는 여기서 그 기능을 다 받아줘야한다.
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException {
		/*
		 * 1. 도시락 싼다...cmd 객체 생성 2. 싼 도시락 던진다...juryThread가 받는다.
		 * -------------------------------------- 3. jury가 던진 도시락 다시 받는다. 4. 잘못된 경우(-) |
		 * 잘된 경우(0)
		 */
		cmd = new Command(Command.ADDCUSTOMER);
		String[] str = { cust.getSsn(), cust.getName(), cust.getAddress() }; // 반찬
		cmd.setArgs(str);
		
		// 서버로 날린다.
		writeCommand(cmd);
//		try {
//			oos.writeObject(cmd);
//			System.out.println("Client writeObject cmd...end");
//		} catch (IOException e) {
//			System.out.println("Client writeObject cmd...error " + e);
//		}
		
		// blocking...서버가 던지는 도시락 다시 받을 때까지(응답이 올 때까지) 대기 상태...
		int status = getResponse();
//		try {     // ois.readObject()의 리턴 타입은 Object라 캐스팅해줘야 함
//			cmd = (Command) ois.readObject(); // 응답에 대한 status이 같이 온다.
//			System.out.println("Client readObject cmd...end");
//		} catch (Exception e) {
//			System.out.println("Client readObject cmd...error " + e);
//		}
//		int status = cmd.getResults().getStatus(); // 클라이언트의 Result와 서버의 Result는 정확히 같은 모양일까
		if (status == -2) throw new DuplicateSSNException();
		// 서버쪽 에러인 경우는?
	}

	public void deleteCustomer(String ssn) throws RecordNotFoundException {
		// Data Pack...Mashalling...setter or constructor
		cmd = new Command(Command.DELETECUSTOMER);
		String[] str = { ssn };
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		// DataUnpack...UnMashalling...getter
		int status = getResponse();
		if (status == -1) throw new RecordNotFoundException();
	}

	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException {
		cmd = new Command(Command.UPDATECUSTOMER);
		String[] str = { cust.getSsn(), cust.getName(), cust.getAddress() };
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		int status = getResponse();
		if (status == -1) throw new RecordNotFoundException();
	}

//	Vector<SharesRec> getPortfolio(String ssn) throws SQLException; // 얘는 서버에서 다른 함수와 같이 돌아가기 때문에 클라이언트에 필요x

	public CustomerRec getCustomer(String ssn) {
		cmd = new Command(Command.GETCUSTOMER);
		String[] str = { ssn };
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		getResponse();
		CustomerRec cust = (CustomerRec) cmd.getResults().get(0);
		return cust;
	}

	public ArrayList<CustomerRec> getAllCustomers() {
		cmd = new Command(Command.GETALLCUSTOMER);
		
		writeCommand(cmd);
		
		getResponse();
		ArrayList<CustomerRec> list = (ArrayList<CustomerRec>) cmd.getResults().get(0);
		return list;
	}

	public ArrayList<StockRec> getAllStocks() {
		cmd = new Command(Command.GETALLSTOCK);
		
		writeCommand(cmd);
		
		getResponse();
		ArrayList<StockRec> list = (ArrayList<StockRec>) cmd.getResults().get(0);
		return list;
	}

	public void buyShares(String ssn, String symbol, int quantity) {
		cmd = new Command(Command.BUYSHARES);
		String[] str = { ssn, symbol, String.valueOf(quantity) };
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		getResponse();
	}

	public void sellShares(String ssn, String symbol, int quantity)
			throws InvalidTransactionException, RecordNotFoundException {
		cmd = new Command(Command.SELLSHARES);
		String[] str = { ssn, symbol, quantity + "" };
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		int status = getResponse();
		if (status == -1) throw new RecordNotFoundException();
		else if (status == -3) throw new InvalidTransactionException();
	}

}
