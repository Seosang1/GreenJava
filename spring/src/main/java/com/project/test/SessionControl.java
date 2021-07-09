package com.project.test;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 


@Controller
@RequestMapping("/cookie.do")
public class SessionControl { 
	
	@PostMapping
	public String make(HttpServletResponse response) {
		Cookie cookie = new Cookie("cookieN", "cookieV");
		cookie.setPath("/");
		
		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);
		
		return "cookie.do";
				
	}
	
	@GetMapping 
	public String form(@CookieValue(value = "cookieName", required = false) Cookie coookie) { 
		if(coookie != null) { //cookieValue 변수에 쿠키 값을 저장한다. 
			String cookieValue = coookie.getValue(); }
		
		
		return "cookie.do";
	}
}


