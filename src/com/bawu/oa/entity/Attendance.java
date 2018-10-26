package com.bawu.oa.entity;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String userId;

	private Date signIn;

	private Date signOut;

	private String ip;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getSignIn() {
		return signIn;
	}

	public void setSignIn(Date signIn) {
		this.signIn = signIn;
	}

	public Date getSignOut() {
		return signOut;
	}

	public void setSignOut(Date signOut) {
		this.signOut = signOut;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", userId=" + userId + ", signIn=" + signIn + ", signOut=" + signOut + ", ip="
				+ ip + "]";
	}

}
