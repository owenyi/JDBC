package com.encore.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.model.Item;

public interface ItemDaoTemplate {

	ArrayList<Item> getAllItem() throws SQLException;

	Item getItem(int itemid) throws SQLException;

	boolean updateRecordCount(int itemid) throws SQLException;

}
