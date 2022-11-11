package com.concordia.flight.radar.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.concordia.flight.radar.dao.UpdateHistoryDao;

public class UpdateHistoryDaoImpl implements UpdateHistoryDao {

	private Connection conn;

	public UpdateHistoryDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Date getLastUpdateTimeOnCountryTable() throws Exception {
		String tableName = "Country";
		return getLastUpdateDate(tableName);

	}

	private Date getLastUpdateDate(String tableName) throws SQLException {
		String genricQuery = "select last_update from update_history where table_name =\"" + tableName + "\";";
		Statement ss = conn.createStatement();
		ResultSet rs = ss.executeQuery(genricQuery);
		Date ds = null;
		if (rs.next()) {
			Timestamp timestamp = rs.getTimestamp(1);
			ds = new java.util.Date(timestamp.getTime());
		}
		// TODO:
		System.out.println(ds);
		
		return ds;
	}

	@Override
	public Date getLastUpdateTimeOnFlightInfoTable() throws Exception {
		String tableName = "flight_info";
		return getLastUpdateDate(tableName);
	}

}
