package com.elearning.model;

public class UserRegisterReturnObject {
	
	long userId;
	boolean registerSuccess;
	String msgReturned;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean isRegisterSuccess() {
		return registerSuccess;
	}
	public void setRegisterSuccess(boolean registerSuccess) {
		this.registerSuccess = registerSuccess;
	}
	public String getMsgReturned() {
		return msgReturned;
	}
	public void setMsgReturned(String msgReturned) {
		this.msgReturned = msgReturned;
	}

}
