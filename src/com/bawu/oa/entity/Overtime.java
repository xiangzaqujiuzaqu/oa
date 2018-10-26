package com.bawu.oa.entity;

import java.io.Serializable;
import java.util.Date;

public class Overtime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private User user;
	private Date applicationTime;
	private Date startTime;
	private Date endTime;
	private int duration;
	private String des;
	private int status;// 0：未审核 1：审核成功 2：审核失败 默认：0

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Overtime [id=" + id + ", user=" + user + ", applicationTime=" + applicationTime + ", startTime="
				+ startTime + ", endTime=" + endTime + ", duration=" + duration + ", des=" + des + ", status=" + status
				+ "]";
	}

}
