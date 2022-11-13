package com.concordia.flight.radar.dbUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

public class DBConnection {

	private static final Logger log = Logger.getLogger(DBConnection.class);
	private Connection conn = null;
	private static DBConnection instance;

	private DBConnection() {

	}

	private static Map<String, String> dbProperties = new HashMap<>();
	static {
		try (FileReader reader = new FileReader("src/main/resources/Properties/db.properties")) {
			Properties p = new Properties();
			p.load(reader);
			Set<Entry<Object, Object>> set = p.entrySet();
			Iterator<Entry<Object, Object>> itr = set.iterator();
			while (itr.hasNext()) {
				Entry<Object, Object> entry = itr.next();
				dbProperties.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (FileNotFoundException e) {
			log.error("Unable to load/file not found db properties files", e);
		} catch (IOException e) {
			log.error("Unable to read db properties files", e);
		}
	}

	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		} else
			try {
				if (instance.getConnection().isClosed())
					instance = new DBConnection();
			} catch (SQLException e) {
				log.error("Db connection failed", e);
			}
		return instance;
	}

	protected void close() {
		if (conn != null) {
			try {
				log.info("Closing database connection");
				conn.close();
			} catch (SQLException e) {
				log.error("Unable to close connection", e);
			}
			conn = null;
		}
	}

	protected Connection getConnection() {
		if (conn == null) {
			log.info("Opening connection");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(dbProperties.get("jdbc.url"), dbProperties.get("jdbc.username"),
						dbProperties.get("jdbc.password"));
			} catch (Exception e) {
				log.error("Unable to eastablish db connection", e);
			}
		}
		return conn;
	}

}