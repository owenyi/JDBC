package broker.three.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import broker.three.shares.Command;
import broker.three.shares.Result;
import broker.three.vo.CustomerRec;

public class JuryThreadMy extends Thread {
	
	private Socket s;
	private Database db;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private Command cmd;
	
	public JuryThreadMy(Socket s, Database db) {
		super();
		this.s = s;
		this.db = db;
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCommand(Command cmd) {
		try {
			oos.writeObject(cmd);
			System.out.println("Client writeObject cmd...end");
		} catch (IOException e) {
			System.out.println("Client writeObject cmd...error " + e);
		}
	}
	
	public Command prepareCommand(Command cmd) {
		// 분기처리 이후에 Command <- response + String[]비우고 +Result 넣
		Command resultCmd = null;
		switch (cmd.getCommandValue()) {
//		case cmd.ADDCUSTOMER:
//			String ssn = cmd.getArgs()[0];
//			String name = cmd.getArgs()[0];
//			String address = cmd.getArgs()[0];
//			CustomerRec cust = new CustomerRec(ssn, name, address);
//			db.addCustomer(cust);
//			break;
		}
		return resultCmd;
	}
	
	public void run() {
		try {
			cmd = (Command) ois.readObject();
			cmd = prepareCommand(cmd);
			writeCommand(cmd);
		} catch (Exception e) {
			
		}
	}
	
}
