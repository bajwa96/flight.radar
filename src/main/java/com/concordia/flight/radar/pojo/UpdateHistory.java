package com.concordia.flight.radar.pojo;

import java.util.Date;

public class UpdateHistory extends BasePojo {
	private Integer pkUpdateHistoryId;
	private String tableName;
	private Date last_update;

	public Integer getPkUpdateHistoryId() {
		return pkUpdateHistoryId;
	}

	public void setPkUpdateHistoryId(Integer pkUpdateHistoryId) {
		this.pkUpdateHistoryId = pkUpdateHistoryId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[pkUpdateHistoryId:").append(pkUpdateHistoryId).append(", ");
		str.append("tableName:").append(tableName).append(", ");
		str.append("last_update:").append(last_update).append("]");
		return str.toString();
	}

}
