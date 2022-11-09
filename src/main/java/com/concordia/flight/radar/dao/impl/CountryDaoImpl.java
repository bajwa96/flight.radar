package com.concordia.flight.radar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dao.CountryDao;
import com.concordia.flight.radar.pojo.Country;

public class CountryDaoImpl implements CountryDao {
	private static final Logger log = Logger.getLogger(CountryDaoImpl.class);

	private static final String INSERT_QUERY = "INSERT IGNORE INTO flightRadar.Country\n"
			+ "(name, code, code3, updateTime, updateUser, createTime, createUser)\n" + "VALUES(?, ?, ?, ?, ?, ?, ?)"
			+ "ON DUPLICATE KEY UPDATE name=?, code3=?, updateUser=?, updateTime=?;";

	private Connection conn;

	public CountryDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createCountryTable() throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS `Country` (\n" + "  `name` varchar(100) NOT NULL,\n"
				+ "  `code` varchar(100) NOT NULL,\n" + "  `code3` varchar(100) NOT NULL,\n"
				+ "  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP,\n"
				+ "  `updateUser` varchar(100) DEFAULT 'System',\n"
				+ "  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,\n"
				+ "  `createUser` varchar(100) DEFAULT 'System',\n" + "  PRIMARY KEY (`code`)\n" + ") ";
		Statement temp;
		temp = conn.createStatement();
		boolean isSuccess = temp.execute(query);
		System.out.print("Create Country Table, success:" + isSuccess);
	}

	@Override
	public void createOrUpdate(List<Country> countries) throws Exception {
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
		for (int index = 0; index < countries.size(); index++) {
			Country country = countries.get(index);
			preparedStatement.setObject(1, country.getCountryName());
			preparedStatement.setObject(2, country.getCode());
			preparedStatement.setObject(3, country.getCode3());
			preparedStatement.setObject(4, new Date());
			preparedStatement.setObject(5, this.getClass().getTypeName());
			preparedStatement.setObject(6, new Date());
			preparedStatement.setObject(7, this.getClass().getTypeName());
			preparedStatement.setObject(8, country.getCountryName());
			preparedStatement.setObject(9, country.getCode3());
			preparedStatement.setObject(10, this.getClass().getTypeName());
			preparedStatement.setObject(11, new Date());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		log.debug("Success executing insert/update on country table");

	}

}
