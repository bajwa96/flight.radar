package com.concordia.flight.radar.managerImpl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.concordia.flight.radar.dbUtils.CommonDbUtil;

public class ManagerBase extends CommonDbUtil {
	private static final Logger log = Logger.getLogger(ManagerBase.class);

	protected void preConfig() throws Exception {
		if (conn.isClosed()) {
			newDBConnection();
		}
		this.conn.setAutoCommit(false);
	}

	protected void postConfig() throws Exception {
		this.conn.commit();
		this.conn.setAutoCommit(true);
	}

	protected void failedTransaactionHandler() {
		try {
			this.conn.rollback();
			this.conn.setAutoCommit(true);
		} catch (SQLException e) {
			log.error("Failed to rollback transaction", e);
		}

	}
}