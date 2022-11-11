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

}

//
//-- flightRadar.update_history definition
//
//CREATE TABLE `update_history` (
//  `pk_update_history_id` int NOT NULL AUTO_INCREMENT,
//  `table_name` varchar(100) NOT NULL,
//  `last_update` datetime DEFAULT NULL,
//  `update_user` varchar(100) DEFAULT NULL,
//  `update_time` datetime DEFAULT NULL,
//  `create_user` varchar(100) DEFAULT NULL,
//  `create_time` datetime DEFAULT NULL,
//  PRIMARY KEY (`pk_update_history_id`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;