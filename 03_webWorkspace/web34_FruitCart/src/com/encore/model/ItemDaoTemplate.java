package com.encore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDaoTemplate {
	
	ArrayList<Item> getAllItem() throws SQLException;
	Item getItem(int itemid) throws SQLException;
	boolean updateRecordCount(int itemid) throws SQLException;
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
}