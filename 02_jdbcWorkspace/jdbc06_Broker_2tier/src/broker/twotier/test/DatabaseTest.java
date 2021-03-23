package broker.twotier.test;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {

		Database db = new Database("127.0.0.1");
//		db.addCustomer(new CustomerRec("111-200", "Yufirst10", "Incheon"));
//		db.deleteCustomer("111-200");
//		db.updateCustomer(new CustomerRec("111-200", "Yufirst10", "Seongnam"));
//		for (SharesRec sr : db.getPortfolio("111-200")) System.out.println(sr);
//		System.out.println(db.getCustomer("111-200"));
//		for (CustomerRec cr : db.getAllCustomers()) System.out.println(cr);
//		for (StockRec sr : db.getAllStocks()) System.out.println(sr);
//		db.buyShares("111-200", null, 0);
		
	}

}
