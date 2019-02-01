package com.reonsoft.example.member.vo;

//로그인 화면으로부터 전달되는 회원의 데이터 수집 용도
public class LoginDTO {
	private String userId;
	private String userPw;
	private boolean userCookie;
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String userId, String userPw, boolean userCookie) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userCookie = userCookie;
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
	public boolean isUserCookie() {
		return userCookie;
	}
	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
