package com.concordia.flight.radar.dbUtils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.concordia.flight.radar.managerImpl.FlightInfoManagerImpl;

@Component
public class CommonDbUtil {
	private static final Logger log = Logger.getLogger(FlightInfoManagerImpl.class);
	protected Connection conn;

	public CommonDbUtil() {
		conn = DBConnection.getInstance().getConnection();
	}

	protected void newDBConnection() {
		conn = DBConnection.getInstance().getConnection();
	}

	@PreDestroy
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			log.error("Unable to close db connection", e);
		}
	}

	public Connection getConn() {
		return conn;
	}

}
