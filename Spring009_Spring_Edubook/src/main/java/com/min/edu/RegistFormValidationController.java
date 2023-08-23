package com.min.edu;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.vo.RegistValidateDto;

@Controller
public class RegistFormValidationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/formValidation.do")
	public String formValidation() {
		logger.info("FormValidation 화면이동");
		return "formValidation";
	}
	
	@ModelAttribute("registValidateDto")
	public RegistValidateDto modelAttribute() {
		RegistValidateDto vo = new RegistValidateDto();
		return vo;
	}
	
	@PostMapping(value = "/regist.do")
	public String regist(
			@ModelAttribute("registValidateDto") @Valid RegistValidateDto registValidateDto,
			BindingResult result
			) {
		logger.info("ValidationController 회원가입 {}", registValidateDto);
		String view ="";
		
		if(result.hasErrors()) {
			logger.info("BindingResult에 오류값 생성");
			view = "formValidation";
		} else {
			logger.info("회원가입 완료");
			view = "redirect:/main.do";
		}
		
		return view;
	}
	
}
