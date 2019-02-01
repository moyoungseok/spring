package com.reonsoft.example.member.service;

import com.reonsoft.example.member.vo.LoginDTO;
import com.reonsoft.example.member.vo.UserVO;

public interface UserService {
	
	//회원가입
	public void register(UserVO userVO) throws Exception;
	
	//네이버 회원가입
	public void nvRegister(UserVO userVO) throws Exception;

	//아이디 중복확인
	public String idCheck(String userId) throws Exception;

	//로그인
	public UserVO login(LoginDTO dto) throws Exception;

	//네이버 로그인 유니크 아이디 확인
	public UserVO naverLogin(String uniqId) throws Exception;

}
