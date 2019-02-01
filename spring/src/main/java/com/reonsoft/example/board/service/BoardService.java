package com.reonsoft.example.board.service;

import java.util.List;

import com.reonsoft.example.board.vo.BBSVO;
import com.reonsoft.example.board.vo.BaseVO;
import com.reonsoft.example.board.vo.ReplyVO;

/*
 * @ 서비스명 : 게시판 Service
 * @ 파일명   : BoardService.java
 * @ 작성자   : 모영석
 * @ 작성일   : 2019. 01. 14.
 *******************************************************************
수정일			수정자	수정내용
 *******************************************************************
2019. 01. 14.	모영석	최초작성
 *******************************************************************
 */
public interface BoardService {
	
	public List<BBSVO> selectBBSList(BaseVO base) throws Exception;
	
	public int totalCountBBS() throws Exception;
	
	public BBSVO selectBBSInfo(int bbsNo) throws Exception;
	
	public int insertBBS(BBSVO vo) throws Exception;
	
	public int updateBBS(BBSVO vo) throws Exception;
	
	public int deleteBBS(int bbsNo) throws Exception;

	//댓글등록
	public int insertRPL(ReplyVO rvo) throws Exception;

	//선택한 게시물의 댓글들 불러오기
	public List<ReplyVO> selectRPLInfo(int bbsNo) throws Exception;

	//댓글 삭제
	public int deleteRPL(ReplyVO rvo) throws Exception;

	//댓글 수정
	public int updateRPL(ReplyVO rvo) throws Exception;

	
}
