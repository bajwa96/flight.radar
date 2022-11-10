package com.concordia.flight.radar.dbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class CommonDbUtil {
	protected Connection conn;

	public CommonDbUtil() {
		conn = DBConnection.getInstance().getConnection();
	}
	
	protected void newDBConnection() {
		conn = DBConnection.getInstance().getConnection();
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	
}
