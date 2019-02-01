package com.reonsoft.example.member.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reonsoft.example.member.service.UserService;
import com.reonsoft.example.member.vo.LoginDTO;
import com.reonsoft.example.member.vo.UserVO;

@Controller
public class UserLoginController {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Resource(name="UserService")
	
	private UserService userService;
	
	/* GoogleLogin */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	//로그인창으로 이동
	@RequestMapping(value="/login")
	public String loginView(Model model, HttpSession session) throws Exception{
	
		//구글 코드 발행
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		//로그인 페이지 이동 url 생성
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		
		System.out.println("구글 : "+url);
		model.addAttribute("google_url",url);

		return "/user/login";
	}
	
	//구글 callback 호출 메소드
	@RequestMapping(value = "/oauth2callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String googleCallback(Model model, @RequestParam String code) throws IOException {
		System.out.println("여기는 googleCallback");
		return "/user/loginPost";
	}
	
	//네이버 callback 호출 메소드
	@RequestMapping(value="/naverCallback")
	public String naverCallback() throws Exception{
		return "/user/naverCallback";
	}
	
	//네이버 유니크 아이디 여부 확인
	@RequestMapping(value="/naverUnique")
	public String naverLoginPost(String uniqId,RedirectAttributes redirectAttributes) throws Exception{
		logger.info("유니크아이디 : "+uniqId);
		UserVO userVO = userService.naverLogin(uniqId);
		redirectAttributes.addAttribute("uniqId",uniqId);
		if(userVO!=null) {
			return "redirect:/user/naverLogin";
		}
			return "redirect:/naverJoinPg";
	}
	
	//로그인
	@RequestMapping(value="/user/loginPost")
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{

		UserVO userVO=userService.login(dto);
		
		//vo가 null이면 메서드를 종료시킨다.
		if(userVO==null || !BCrypt.checkpw(dto.getUserPw(), userVO.getUserPw())) {
			return;
		}
		logger.info(userVO.toString());
		model.addAttribute("user",userVO);
	} 
	
	//네이버 로그인
	@RequestMapping(value="/user/naverLogin")
	public void naverLogin(String uniqId, HttpSession session, Model model) throws Exception{
		UserVO userVO=userService.naverLogin(uniqId);
		logger.info("네이버로그인 :"+userVO.toString());
		model.addAttribute("user",userVO);
		
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception{
		
		Object object = httpSession.getAttribute("login");
		if(object!=null) {
			UserVO userVO = (UserVO) object;
			httpSession.removeAttribute("login");
			httpSession.invalidate();
		}
		return "/user/logout";
		
	}
}
