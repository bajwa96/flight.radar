package com.concordia.flight.radar.dbUtils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class CommonDbUtil {
	protected Connection conn;

	public CommonDbUtil() {
		conn = DBConnection.getInstance().getConnection();
	}

	protected void newDBConnection() {
		conn = DBConnection.getInstance().getConnection();
	}

	@PreDestroy
	public void closeConnection() {
		System.out.println("Conn CLosed");
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
