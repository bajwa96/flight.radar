package com.concordia.flight.radar.pojo;

import java.util.Date;

/**
 * Base pojo contains the audit columns which could be used by various db objects
 * instead of declaring them in every class declaring them in common class
 *
 */
public abstract class BasePojo {
	private String createUser;
	private String updateUser;
	private Date createTime;
	private Date updateTime;
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public abstract String toString();
}
