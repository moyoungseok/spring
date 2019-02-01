package com.reonsoft.example.member.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserVO {
	private String uniqueId;
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userJoinDate;
	private char userActive;
	
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserVO(String uniqueId, int userNo, String userId, String userPw, String userName, String userEmail,
			String userJoinDate, char userActive) {
		super();
		this.uniqueId = uniqueId;
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userJoinDate = userJoinDate;
		this.userActive = userActive;
	}
	
	public String getUniqId() {
		return uniqueId;
	}



	public void setUniqId(String uniqueId) {
		this.uniqueId = uniqueId;
	}



	public int getUserNo() {
		return userNo;
	}



	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserPw() {
		return userPw;
	}



	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserJoinDate() {
		return userJoinDate;
	}



	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}



	public char getUserActive() {
		return userActive;
	}



	public void setUserActive(char userActive) {
		this.userActive = userActive;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	           
}
