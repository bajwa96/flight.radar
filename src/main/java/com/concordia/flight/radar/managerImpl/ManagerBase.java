package com.concordia.flight.radar.managerImpl;

import com.concordia.flight.radar.dbUtils.CommonDbUtil;

public class ManagerBase extends CommonDbUtil  {
	protected void preConfig() throws Exception {
		System.out.println("before");
		if(conn.isClosed()) {
			newDBConnection();
		}
		this.conn.setAutoCommit(false);
	}
	protected void postConfig() throws Exception {
		this.conn.commit();
		System.out.println("After");
	}
}
