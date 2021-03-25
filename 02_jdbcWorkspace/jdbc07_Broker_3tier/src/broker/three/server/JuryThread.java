package broker.three.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.shares.Result;
import broker.three.vo.CustomerRec;
import broker.three.vo.StockRec;

public class JuryThread extends Thread {
	
	private Socket s;
	private Database db;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private Command cmd;
	
	public JuryThread(Socket s, Database db) {
		super();
		this.s = s;
		this.db = db;
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Jury...Creating...");
	}

	public void writeCommand(Command cmd) {
		try {
			oos.writeObject(cmd);
			System.out.println("Client writeObject cmd...end");
		} catch (IOException e) {
			System.out.println("Client writeObject cmd...error " + e);
		}
	}
	
	/*
	 * 1. protocol이 보낸 도시락 받는다...readObject()
	 * 2. 도시락 깐다...10~90
	 * 3. 10~90 상수 값에 해당하는 Database메소드를 직접 호출한다.(DB에 요청)
	 *   이 때 인자 값 알아서 잘 넣어준다.
	 * 4. DB의 응답 값을 다시 도시락에 싸서 Protocol로 보낸다.
	 */
	public void run() {
		System.out.println("Jury...run()...진입");
		while (true) { // Protocol에서 접속을 한 번만 하니까 무한 루핑으로 만드는 게 맞다.
			try {
				// 1. 도시락 받는다.
				cmd = (Command) ois.readObject();
				System.out.println("cmd...Jury readObject()...");
			} catch (Exception e) {
				
			}
			// 2. 도시락 깐다...Data UnPack...Getter
			int comm = cmd.getCommandValue();
			String[] args = cmd.getArgs();
			Result r = cmd.getResults();
			
			// 3. comm 값에 따라서 Database의 메소드를 각각 호출한다.
			switch (comm) { // 실수형은 인자 값 안된다.
				case Command.BUYSHARES:
					try {
						db.buyShares(args[0], args[1], Integer.parseInt(args[2]));
						// 성공했으니
						r.setStatus(0);
					} catch (Exception e) {
						
					}
					break;
				case Command.SELLSHARES:
					try {
						db.sellShares(args[0], args[1], Integer.parseInt(args[2]));
						r.setStatus(0);
					} catch (RecordNotFoundException e) {
						r.setStatus(-1);
					} catch (InvalidTransactionException e) {
						r.setStatus(-3);
					} catch (Exception e) {
						
					}
					break;
				case Command.GETALLSTOCK:
					try {
//						r = (Result) db.getAllStocks(); // 이거 아님
//						r.set(0, db.getAllStocks()); // 이것도 될 것 같긴 한데
						ArrayList<StockRec> list = db.getAllStocks();
						r.setStatus(0);
						r.add(list);
						
						// 4. 다시 도시락 싸기...보내는 건 맨 아래서 일괄 writeCommand()
//						cmd.setResults(r); // r 이 cmd 안에 들어있는 애라서 이렇게 할 필요 없음
					} catch (Exception e) {
						
					}
					break;
				case Command.GETALLCUSTOMER:
					try {
						ArrayList<CustomerRec> list = db.getAllCustomers();
						r.setStatus(0);
						r.add(list);
					} catch (Exception e) {
						
					}
					break;
				case Command.GETCUSTOMER:
					try {
						CustomerRec cr = db.getCustomer(args[0]);
						r.setStatus(0);
						r.add(cr);
					} catch (Exception e) {
						
					}
					break;
				case Command.ADDCUSTOMER:
					try {
						db.addCustomer(new CustomerRec(args[0], args[1], args[2]));
						r.setStatus(0);
					} catch (DuplicateSSNException e) {
						r.setStatus(-2);
					} catch (Exception e) {
						
					}
					break;
				case Command.DELETECUSTOMER:
					try {
						db.deleteCustomer(args[0]);
						r.setStatus(0);
					} catch (RecordNotFoundException e) {
						r.setStatus(-1);
					} catch (Exception e) {
						
					}
					break;
				case Command.UPDATECUSTOMER:
					try {
						db.updateCustomer(new CustomerRec(args[0], args[1], args[2]));
						r.setStatus(0);
					} catch (RecordNotFoundException e) {
						r.setStatus(-1);
					} catch (Exception e) {
						
					}
					break;
			}
			try {
				oos.writeObject(cmd);
			} catch (IOException e) {
				
			}
//			writeCommand(cmd);
		}
	}
	
}
