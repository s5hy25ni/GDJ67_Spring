package com.min.edu;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.model.service.ITeacherService;
import com.min.edu.vo.TeacherVO;

@RestController
public class SearchTestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ITeacherService service;
	
	@PostMapping("/searchTest.do")
    public List<TeacherVO> subjectSearch(@RequestParam("subject") String subject, @RequestParam("nickname") String nickname) {
		List<TeacherVO> result1 = service.subjectSearch(subject);
		List<TeacherVO> result2 = service.nicknameSearch(nickname);
		if (!result1.isEmpty()) {
            result2 = result2.stream().filter(teacher -> result1.contains(teacher)).collect(Collectors.toList());
        }

        logger.info("result1: {}", result1);
        logger.info("result2: {}", result2);
        return result2;
    }

}
