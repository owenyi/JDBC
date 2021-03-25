package broker.three.shares;

import java.io.Serializable;

public class Command implements Serializable { // 얘는 원래 클라이언트와 서버에 각각 있어야 함

	public static final int BUYSHARES = 10; // 여기의 SHARES는 db table
	public static final int SELLSHARES = 20;
	public static final int GETALLSTOCK = 30;
	public static final int GETSTOCKPRICE = 40;
	public static final int GETALLCUSTOMER = 50;
	public static final int GETCUSTOMER = 60;
	public static final int ADDCUSTOMER = 70;
	public static final int DELETECUSTOMER = 80;
	public static final int UPDATECUSTOMER = 90;
	
	private int commandValue;
	private String[] args;
	
	// 결과 통
	private Result results;
	
	public Command(int commandValue) {
		super();
		this.commandValue = commandValue;
		results = new Result();
	}
	
	public int getCommandValue() {
		return commandValue;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	
	//
	public Result getResults() {
		return results;
	}

	public void setResults(Result results) {
		this.results = results;
	}
	
}
