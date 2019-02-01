package com.reonsoft.example.member.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reonsoft.example.member.dao.UserDAO;
import com.reonsoft.example.member.mapper.UserMapper;
import com.reonsoft.example.member.service.UserService;
import com.reonsoft.example.member.vo.LoginDTO;
import com.reonsoft.example.member.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Resource(name="UserDAO")
	private UserDAO userDAO;
	
	//회원가입
	@Override
	public void register(UserVO userVO) throws Exception {
		userDAO.register(userVO);
	}
	
	//네이버 회원가입
	@Override
	public void nvRegister(UserVO userVO) throws Exception {
		userDAO.nvRegister(userVO);
		
	}

	//아이디 중복 확인
	@Override
	public String idCheck(String userId) throws Exception {
		return userDAO.idCheck(userId);
	}

	//로그인
	public UserVO login(LoginDTO dto) throws Exception {
		return userDAO.login(dto);
	}
	
	//네이버 로그인
	
	//네이버 로그인 유니크 아이디 확인
	@Override
	public UserVO naverLogin(String uniqId) throws Exception {
		return userDAO.naverLogin(uniqId);
	}
	
	

}
