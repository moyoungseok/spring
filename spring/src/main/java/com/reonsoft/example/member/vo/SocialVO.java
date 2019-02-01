package com.reonsoft.example.member.vo;

public class SocialVO {
	private int userNo;
	private String uniqueId;
	private int socailNo;
	public SocialVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SocialVO(int userNo, String uniqueId, int socailNo) {
		super();
		this.userNo = userNo;
		this.uniqueId = uniqueId;
		this.socailNo = socailNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getSocailNo() {
		return socailNo;
	}
	public void setSocailNo(int socailNo) {
		this.socailNo = socailNo;
	}
	
}
