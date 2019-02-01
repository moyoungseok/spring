package com.reonsoft.example.board.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reonsoft.example.board.dao.BoardDAO;
import com.reonsoft.example.board.mapper.BoardMapper;
import com.reonsoft.example.board.service.BoardService;
import com.reonsoft.example.board.vo.BBSVO;
import com.reonsoft.example.board.vo.BaseVO;
import com.reonsoft.example.board.vo.ReplyVO;

/*
 * @ 서비스명 : 게시판 ServiceImpl
 * @ 파일명   : BoardServiceImpl.java
 * @ 작성자   : 모영석
 * @ 작성일   : 2019. 01. 14.
 *******************************************************************
수정일			수정자	수정내용
 *******************************************************************
2019. 01. 14.	모영석	최초작성
 *******************************************************************
 */
@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Resource(name="BoardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<BBSVO> selectBBSList(BaseVO base) throws Exception {
		
		List<BBSVO> list = new ArrayList<BBSVO>();
		
		try {
			
			logger.debug("vo {}", base);
			
			//list = boardMapper.selectBBSList(vo);
       		list = boardDAO.selectBBSList(base);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//게시물의 총 개수 
	@Override
	public int totalCountBBS() throws Exception {
		return boardDAO.totalCountBBS();
	}
	

	@Override
	public BBSVO selectBBSInfo(int bbsNo) throws Exception {
		
		BBSVO vo=new BBSVO();
		
		try {
			
			vo=boardDAO.selectBBSInfo(bbsNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
		
	}

	@Override
	public int insertBBS(BBSVO vo) throws Exception {
		return boardDAO.insertBBS(vo);
		
	}

	@Override
	public int  updateBBS(BBSVO vo) throws Exception {
		return boardDAO.updateBBS(vo);
	}

	@Override
	public int deleteBBS(int bbsNo) throws Exception {
		//게시물 삭제시 해당 게시물의 댓글 삭제
		boardDAO.deleteBBSRpl(bbsNo);
		return boardDAO.deleteBBS(bbsNo);
		
	}

	@Override
	public int insertRPL(ReplyVO rvo) throws Exception{
		// TODO Auto-generated method stub
		return boardDAO.insertRPL(rvo);
	}

	@Override
	public List<ReplyVO> selectRPLInfo(int bbsNo) throws Exception {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		list = boardDAO.selectRPLInfo(bbsNo);
		return list;
	}

	@Override
	public int deleteRPL(ReplyVO rvo) throws Exception {
		
		return boardDAO.deleteRPL(rvo);
	}

	@Override
	public int updateRPL(ReplyVO rvo) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.updateRPL(rvo);
	}

}
