package com.reonsoft.example.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.reonsoft.example.board.vo.BBSVO;
import com.reonsoft.example.board.vo.BaseVO;
import com.reonsoft.example.board.vo.ReplyVO;

/*
 * @ 서비스명 : 게시판 DAO
 * @ 파일명   : BoardDAO.java
 * @ XML   : Board_SQL.xml
 * @ 작성일   : 2019. 01. 14.
 *******************************************************************
수정일			수정자	수정내용
 *******************************************************************
2019. 01. 14.	모영석	최초작성
 *******************************************************************
 */
@Repository("BoardDAO")
public class BoardDAO {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<BBSVO> selectBBSList(BaseVO base) throws Exception {
		if(base.getPageIndex()<=0) {
			base.setPageIndex(1);
		}
		
		return sqlSession.selectList("board.dao.selectBBSList", base);
	}
	
	public int totalCountBBS() throws Exception{
		return sqlSession.selectOne("board.dao.totalCountBBS");
	}
	
	public BBSVO selectBBSInfo(int bbsNo) throws Exception {
		sqlSession.update("board.dao.viewCount",bbsNo);
		return sqlSession.selectOne("board.dao.selectBBSInfo",bbsNo);
	}
	
	public int insertBBS(BBSVO vo) throws Exception {
		return sqlSession.insert("board.dao.insertBBS",vo);
	}
	
	public int updateBBS(BBSVO vo) throws Exception {
		return sqlSession.update("board.dao.updateBBS",vo);
	}
	
	public void deleteBBSRpl(int bbsNo) throws Exception{
		sqlSession.delete("board.dao.deleteBBSRpl",bbsNo);
		
	}
	
	public int deleteBBS(int bbsNo) throws Exception {
		return sqlSession.delete("board.dao.deleteBBS", bbsNo);
	}

	public int insertRPL(ReplyVO rvo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.dao.insertRPL",rvo);
	}

	public List<ReplyVO> selectRPLInfo(int bbsNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.dao.selectRPLList", bbsNo);
	}

	public int deleteRPL(ReplyVO rvo) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.delete("board.dao.deleteRPL",rvo);
	}

	public int updateRPL(ReplyVO rvo) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.update("board.dao.updateRPL",rvo);
	}

	
}
