package com.min.edu;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MailController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/mailForm.do")
	public String mail() {
		logger.info("MailController 메일폼 작성 화면 이동");
		return "mailForm";
	}
	
	@PostMapping("/mailSender.do")
	public String mailSender(@RequestParam Map<String, String> mailMap) {
		logger.info("MailController mailSender.do 전송값 {}", mailMap);
		
		// 발신자의 메일주소가 반드시 MimeMessage 객체에 입력되어있어야함
		String setFrom = "pattern_a@naver.com";
		
		//메일 내용을 전송하기 위한 객체 MimeMessage
		MimeMessage message = mailSender.createMimeMessage();
	
		// MimeMessageHelper 전송을 처리해주는 객체, MimeMessage(송신서버정보), 첨부파일여부 t/f, 글자인코딩
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setFrom); //보내는 사람이메일, 생략하면 안됨
			messageHelper.setTo(mailMap.get("tomail"));
			messageHelper.setSubject(mailMap.get("title")); //생략가능
			messageHelper.setEncodeFilenames(true); //첨부파일 인코딩
			
			//본문의 내용
			//true로 체크하면 글자를 HTML 형식을 바인딩, false는 text
			messageHelper.setText(mailMap.get("content"), true);
			
			//첨부파일 처리
			//MimeMessageHelper의 옵션중에서 두번째 옵션(multipart)이 true면 가능
			FileSystemResource fileResource = new FileSystemResource("C:\\eclipse_spring\\00100.png");
			messageHelper.addAttachment("꼬부기.png", fileResource);
			
			System.out.println("mailSender: "+mailSender.toString());
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "redirect:/main.do";
	}
	
	
}
