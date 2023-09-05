package com.min.edu;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.edu.model.service.FileService;
import com.min.edu.model.service.ITeacherService;

@Controller
public class PDFController {
	
	@Autowired
	private ITeacherService teacherService;

	@Autowired
	private FileService fileService;

	@ResponseBody
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public Map<String, Object> fileUpload(HttpServletRequest request,
			List<MultipartFile> file, String desc) {

	    Map<String, Object> response = new HashMap<>();

	    for (MultipartFile f : file) {
	        try {
	            String savedFilePath = fileService.saveFile(f, request);
	            List<String> pngFileNames = fileService.convertPdfToPng(savedFilePath,request.getSession().getServletContext().getRealPath("/storage")+"/");
	            for (String pngFileName : pngFileNames) {
	                Map<String, Object> ocrMap = fileService.extractTextFromAreas(request.getSession().getServletContext().getRealPath("/storage")+"/"+pngFileName);

	                for (Object value : ocrMap.values()) {
	                    if (value == null || "".equals(value.toString().trim())) {
	                        response.put("errorMessage", "모든 항목은 반드시 기재되어야 합니다.");
	                        return response;
	                    }
	                }

	                int n = teacherService.careerInsert(ocrMap);
	                if(n > 0) System.out.println("insert 성공!!!!!");
	            }
	            
	            // OCR 처리와 DB 저장이 끝나면 PNG 파일 삭제
                fileService.deletePngFiles(pngFileNames,request.getSession().getServletContext().getRealPath("/storage"));

	            
	        } catch (Exception e) { 
	            e.printStackTrace();
	        }
	    }

	    return response; 
	}

}
