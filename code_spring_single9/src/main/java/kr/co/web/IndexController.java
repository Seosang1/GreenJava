package kr.co.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
   
   @RequestMapping(value = "/PEOPLE")
   public String people(Model model) {
      
      return "jsp/main/PEOPLE";
   }
   
   @RequestMapping(value = "/LOCATION")
   public String location(Model model) {
      
      return "jsp/main/LOCATION";
   }
   
   
   //濡 洹몄  
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
   
   //      蹂      
   @RequestMapping(value = "/memberUpdateView")
   public String MemberUpdateView() {
      return "jsp/member/memberUpdate";
   }
   
   //鍮 諛 踰        
   @RequestMapping(value = "/memberPwdUpdateView")
   public String MemberPwdUpdateView() {
      return "jsp/member/memberPwdUpdate";
   }
   
   //鍮 諛 踰    李얘린
   @RequestMapping(value = "/findPwdView")
   public String findPwdView() {
      return "jsp/member/findPwd";
   }
   
   //id 李얘린
   @RequestMapping(value = "/findIdView")
   public String findIdView() {
      return "jsp/member/findId";
   }
   
    
}