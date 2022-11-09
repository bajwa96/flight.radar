package com.concordia.flight.radar.dbUtils;

import java.sql.Connection;

public class CommonDbUtil {
	protected Connection conn;

	protected CommonDbUtil() {
		conn = DBConnection.getInstance().getConnection();
	}
	
	protected void newDBConnection() {
		conn = DBConnection.getInstance().getConnection();
	}
	
	protected void closeConnection() throws Exception {
		conn.close();
	}

}
