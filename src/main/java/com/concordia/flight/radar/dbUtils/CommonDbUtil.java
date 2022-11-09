package com.concordia.flight.radar.dbUtils;

import java.sql.Connection;

//import org.apache.log4j.Logger;

public class CommonDbUtil {
	protected Connection conn;

	protected CommonDbUtil() {
		conn = new DBConnection().getConnection();
	}
	
	protected void newDBConnection() {
		conn = new DBConnection().getConnection();
	}
	
	protected void closeConnection() throws Exception {
		conn.close();
	}

}
