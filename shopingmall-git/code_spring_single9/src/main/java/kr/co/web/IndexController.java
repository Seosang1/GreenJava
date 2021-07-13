package kr.co.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		return "jsp/main";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		
		return "jsp/main";
	}
	@RequestMapping(value = "/board/main")
	public String toMain(Model model) {
		
		return "jsp/main";
	}
	
	@RequestMapping(value = "/ABOUT")
	public String about(Model model) {
		
		return "jsp/main/ABOUT";
	}
	
	@RequestMapping(value = "/SHOP")
	public String shop(Model model) {
		
		return "jsp/main/SHOP";
	}
	
	@RequestMapping(value = "/LOOK")
	public String look(Model model) {
		
		return "jsp/main/LOOK";
	}
	
	@RequestMapping(value = "/BOARD")
	public String board(Model model) {
		
		return "jsp/main/BOARD";
	}
	/*
	@RequestMapping(value = "/board/qnaList")
	public String qnaList(Model model) {
		
		return "jsp/board/qnaList";
	}
	@RequestMapping(value = "/board/qnaDetail")
	public String qnaDetail(Model model) {
		
		return "jsp/board/qnaDetail";
	}
	@RequestMapping(value = "/board/qnaView")
	public String qnaView(Model model) {
		
		return "jsp/board/qnaView";
	}
	*/
	
	@RequestMapping(value = "/PEOPLE")
	public String people(Model model) {
		
		return "jsp/main/PEOPLE";
	}
	
	@RequestMapping(value = "/LOCATION")
	public String location(Model model) {
		
		return "jsp/main/LOCATION";
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model,HttpSession session) {
		if(session.getAttribute("loginErr") != null) {
			session.removeAttribute("loginErr");
		}
		return "jsp/member/login";
	}
	
	@RequestMapping(value = "/join")
	public String join(Model model) {
		
		return "jsp/member/join";
	}
	@RequestMapping(value = "/memberUpdateView")
	public String MemberUpdateView() {
		return "jsp/member/memberUpdate";
	}
	
	@RequestMapping(value = "/memberPwdUpdateView")
	public String MemberPwdUpdateView() {
		return "jsp/member/memberPwdUpdate";
	}
	@RequestMapping(value = "/findPwdView")
	public String findPwdView() {
		return "jsp/member/findPwd";
	}
	@RequestMapping(value = "/findIdView")
	public String findIdView() {
		return "jsp/member/findId";
	}
}
