package kr.co.web;

import java.io.Console;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.web.model.Member.MemberBiz;
import kr.co.web.model.Member.MemberDto;

@Controller
@RequestMapping(value="/member")
public class memberController {

	@Autowired 
	private MemberBiz biz;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(memberController.class);
	
	
	//로그인
	public MemberDto login(MemberDto dto) throws Exception {
		return null;
	}
	
	
	//이메일 인증(성공~)
	@RequestMapping(value = "/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String u_email) throws Exception {
		//데이터 확인용인데 안됨...
		logger.info("이메일 데이터 확인");
		logger.info("인증번호: "+u_email);
		
		//인증번호 난수 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호"+checkNum);
		
		String setFrom = "owo_14@daum.net";
		String toMail = u_email;
		String title = "AT Shopping Mall 가입 인증 이메일 입니다.";
		String content = "반갑습니다."+"<br>"+"인증번호는 "+checkNum+" 입니다";
		
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        String num = Integer.toString(checkNum);
		return num;
	}
	
	//id체크 
	
	
	
	
	
}
