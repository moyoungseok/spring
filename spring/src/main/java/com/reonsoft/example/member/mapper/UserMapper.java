package com.reonsoft.example.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.reonsoft.example.member.vo.UserVO;

@Mapper
public interface UserMapper {
	public void register(UserVO userVO) throws Exception;
	
	public UserVO idCheck(String userId) throws Exception;
}
