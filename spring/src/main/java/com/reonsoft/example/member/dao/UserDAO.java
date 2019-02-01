package com.reonsoft.example.member.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.reonsoft.example.member.vo.LoginDTO;
import com.reonsoft.example.member.vo.UserVO;

@Repository("UserDAO")
public class UserDAO {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
		
	//회원가입
	public void register(UserVO userVO) throws Exception{
		sqlSession.insert("member.dao.register",userVO);
	}
	
	//네이버 회원가입
	public void nvRegister(UserVO userVO) throws Exception{
		sqlSession.insert("member.dao.nvRegister",userVO);
	}
	
	//아이디 중복 확인
	public String idCheck(String userId) throws Exception{
		String user=sqlSession.selectOne("member.dao.idCheck",userId);
		System.out.println(user);
		return user;
	}
	
	//로그인 
	public UserVO login(LoginDTO dto) throws Exception{
		return sqlSession.selectOne("member.dao.login",dto);
	}

	//네이버 로그인 유니크아이디 확인
	public UserVO naverLogin(String uniqId) {
		return sqlSession.selectOne("member.dao.naverLogin",uniqId);
	}

}
