package com.concordia.flight.radar.managerImpl;

import com.concordia.flight.radar.dbUtils.CommonDbUtil;

public class ManagerBase extends CommonDbUtil  {
	protected void preConfig() throws Exception {
		if(conn.isClosed()) {
			newDBConnection();
		}
		this.conn.setAutoCommit(false);
	}
	protected void postConfig() throws Exception {
		this.conn.commit();
		this.conn.setAutoCommit(true);
	}
	protected void failedTransaactionHandler() throws Exception {
		this.conn.rollback();
		this.conn.setAutoCommit(true);
	}
}