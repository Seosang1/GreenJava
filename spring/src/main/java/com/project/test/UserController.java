package com.project.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.test.service.*;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user.do")
	public String board(Model model) {
		model.addAttribute("list",userService.selectList());
		return "board";
		
		
		
	}
	

 
	
	


}


