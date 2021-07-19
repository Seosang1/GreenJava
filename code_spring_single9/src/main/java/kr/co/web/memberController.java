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
	
	
	//�α���
	public MemberDto login(MemberDto dto) throws Exception {
		return null;
	}
	
	
	//�̸��� ����(����~)
	@RequestMapping(value = "/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String u_email) throws Exception {
		//������ Ȯ�ο��ε� �ȵ�...
		logger.info("�̸��� ������ Ȯ��");
		logger.info("������ȣ: "+u_email);
		
		//������ȣ ���� ����
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("������ȣ"+checkNum);
		
		String setFrom = "owo_14@daum.net";
		String toMail = u_email;
		String title = "AT Shopping Mall ���� ���� �̸��� �Դϴ�.";
		String content = "�ݰ����ϴ�."+"<br>"+"������ȣ�� "+checkNum+" �Դϴ�";
		
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
	
	//idüũ 
	
	
	
	
	
}
