package com.reonsoft.example.board.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reonsoft.example.board.service.BoardService;
import com.reonsoft.example.board.vo.BBSVO;
import com.reonsoft.example.board.vo.BaseVO;
import com.reonsoft.example.board.vo.Pagination;
import com.reonsoft.example.board.vo.ReplyVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	//리스트 불러오기
	@RequestMapping(value = "/bbsList")
	public String bbsList(Model model,BaseVO base) throws Exception {
				
		logger.debug("BoardController vo {}", base);
		model.addAttribute("bbsList", boardService.selectBBSList(base));
		return "/board/bbsList";
	}
	
	//하단 페이징 처리
	@RequestMapping(value= {"/","/listPage"})
	public String listPage(BaseVO base, Model model) throws Exception{
		logger.info(base.toString());
		
		Pagination page = new Pagination();
		page.setBase(base);
		page.setTotalCount(boardService.totalCountBBS());
		
		model.addAttribute("bbsList",boardService.selectBBSList(base));
		model.addAttribute("page",page);
		
		return "/board/listPage";
	}
	
	//게시물 정보
	@RequestMapping(value = "/bbsInfo")
	public String selectBBSInfo(@RequestParam("bbsNo") int bbsNo, Model model) throws Exception{
		model.addAttribute("bbsInfo", boardService.selectBBSInfo(bbsNo));
		//해당 게시글의 댓글 
		model.addAttribute("rplInfo", boardService.selectRPLInfo(bbsNo));
		return "/board/bbsInfo";
	}
	
	//게시물 작성
	@RequestMapping(value = "/writeBBS")
	public String writeBBS() throws Exception{
		return "/board/bbsInsert";
	}
	
	@RequestMapping(value = "/bbsInsert")
	public String insertBBS(BBSVO vo) throws Exception{
		int result = boardService.insertBBS(vo);
		if(result>0) {
			return "redirect:/listPage";
		}else {
			return "error";
		}
	}
	
	//게시물 수정
	@RequestMapping(value = "/bbsUpdate")
	public String updateBBS(BBSVO vo,@RequestParam("bbsNo") int bbsNo,RedirectAttributes redirectAttributes) throws Exception {
		logger.info(vo.toString());
		int result = boardService.updateBBS(vo);
		//리다이렉트 할 때 파라미터 전달
		redirectAttributes.addAttribute("bbsNo",bbsNo);
		if(result>0) {
			return "redirect:/bbsInfo";
		}else {
			return "error";
		}
	}
	
	//게시물 삭제
	@RequestMapping(value="/bbsDelete")
	public String deleteBBS(@RequestParam("bbsNo") int bbsNo) throws Exception{
		int result=boardService.deleteBBS(bbsNo);
		if(result>0) {
			return "redirect:/listPage";
		}else {
			return "error";
		}
	}
	
	//댓글등록
	@RequestMapping(value = "/rplInsert")
	@ResponseBody 
	public int insertRPL(@RequestBody ReplyVO rvo) throws Exception{
		logger.info(rvo.toString());
		int result = boardService.insertRPL(rvo);
		return result;
	}
	
	//댓글삭제
	@RequestMapping(value="/rplDelete")
	@ResponseBody 
	public int delRPL(@RequestBody ReplyVO rvo) throws Exception{
		System.out.println(rvo.getReplyNo());
		logger.info(rvo.toString());
		int result = boardService.deleteRPL(rvo);
		return result;
	}
	
	//댓글 수정
	@RequestMapping(value="/rplUpdate")
	public int updateRPL(@RequestBody ReplyVO rvo) throws Exception{
		int result = boardService.updateRPL(rvo);
		return result;
	}
}
