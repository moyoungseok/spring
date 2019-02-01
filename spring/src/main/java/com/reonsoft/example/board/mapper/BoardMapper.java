package com.reonsoft.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reonsoft.example.board.vo.BBSVO;

/*
 * @ 서비스명 : 게시판 Mapper
 * @ 파일명   : BoardMapper.java
 * @ XML   : Board_SQL.xml
 * @ 작성일   : 2019. 01. 14.
 *******************************************************************
수정일			수정자	수정내용
 *******************************************************************
2019. 01. 14.	모영석	최초작성
 *******************************************************************
 */
@Mapper
public interface BoardMapper {
	
	public List<BBSVO> selectBBSList(BBSVO bbsVO) throws Exception;
	
	public void selectBBSInfo() throws Exception;
	
	public void insertBBS() throws Exception;
	
	public void updateBBS() throws Exception;
	
	public void deleteBBS() throws Exception;
	
}
