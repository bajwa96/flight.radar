package com.concordia.flight.radar.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class DBConnection {

	private static final Logger log = Logger.getLogger(DBConnection.class);
	private Connection conn = null;

	public void close() {
		if (conn != null) {
			try {
				log.info("Closing database connection to sampleDB");
				conn.close();
			} catch (SQLException e) {
				log.error("Unable to close connection", e);
			}
			conn = null;
		}
	}

	public Connection getConnection() throws SQLException {
		if (conn == null) {
			log.info("Opening connection to sampleDB");
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:sampleDB", "SA", "");
		}
		return conn;
	}
}