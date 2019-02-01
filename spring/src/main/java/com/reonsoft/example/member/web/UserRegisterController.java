package com.reonsoft.example.member.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reonsoft.example.board.web.BoardController;
import com.reonsoft.example.member.service.UserService;
import com.reonsoft.example.member.vo.UserVO;

@Controller
public class UserRegisterController {	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="UserService")
	private UserService userService;
	
	//회원가입창으로 이동
	@RequestMapping(value="/register")
	public String registerView() throws Exception{
		return "/user/register";
	}
		
	//회원가입
	@RequestMapping(value="/userRegister")
	public String register(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception{
		//비밀번호 암호화 작업
		String hashedPw = BCrypt.hashpw(userVO.getUserPw(),BCrypt.gensalt());
		userVO.setUserPw(hashedPw);
		
		logger.info(userVO.toString());
		
		//유니크아이디가 있는 경우(네이버로 로그인한 경우)
		if(userVO.getUniqId()!=null) {
			userService.nvRegister(userVO);
		}else {
			userService.register(userVO);
		}
		redirectAttributes.addFlashAttribute("msg","REGISTERED");
		return "redirect:/login";
	}
	
	//네이버 회원가입
	@RequestMapping(value="/naverJoinPg")
	public String naverJoinPg(@RequestParam("uniqId") String uniqId, Model model) throws Exception{
		model.addAttribute("uniqId",uniqId);
		return "/user/register";
	}

	//회원가입시 아이디 중복확인
	@RequestMapping(value="/idCheck")
	@ResponseBody
	public boolean idCheck(HttpServletRequest req) throws Exception {
		String userId = req.getParameter("userId");
		String user = userService.idCheck(userId);
		
		boolean result = false;
		if(user !=null) {
			result=true;
		}
		return result;
	}
	
	
}
