package com.min.edu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.min.edu.comm.OCRDemo;
import com.min.edu.model.service.ITeacherService;

@Controller
public class PDFConvertController {
	
	@Autowired
	ITeacherService service;
	
	@ResponseBody
//	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public Map<String, Object> fileUpload(HttpServletRequest request,
			List<MultipartFile> file, String desc) {
		System.out.println(file.size());
		System.out.println(desc);
		Map<String, Object> response = new HashMap<>();
		List<String> pngFileNames = new ArrayList<>();
		
		for (MultipartFile f : file) {
			System.out.println(f.getOriginalFilename());
			String originalFileName = f.getOriginalFilename();
			String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
			
			System.out.println("파일명 : "+originalFileName);
			System.out.println("저장 파일명 : "+"./storage/"+saveFileName);
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			String path="";
			
			try {
				//1) 파일을 읽는다
				inputStream = f.getInputStream();
				
				//2) 저장 위치를 만든다
				path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");//상대경로
				System.out.println(request.getSession().getServletContext().getRealPath("storage")); //상대경로
				System.out.println("실제 파일이 업로드될 테스트 경로"+path);
				
				//3) 저장 위치가 없으면 만든다
				File storage = new File(path);
				if(!storage.exists()) {
					storage.mkdir();
				}
				
				//4) 저장할 파일이 기존에 없다면 만들어주고 아니면 오버라이드 함
				File newFile = new File(path+"/"+saveFileName);
				if(!newFile.exists()) {
					newFile.createNewFile();
				}
				
				//5) 파일의 쓸 위치를 지정해줌
				outputStream = new FileOutputStream(newFile);
				
				//6) 파일을 대상에 읽고 써줌
				int read = 0;
				byte[] b = new byte[(int)f.getSize()];
				while ((read=inputStream.read(b))!= -1) {
					outputStream.write(b,0,read);
				}
				
				try {
//					pngFileNames = PDFBoxUtils.convertPdfToPng(path+"/"+saveFileName, path+"/");
					
					Map<String, Object> ocrMap = OCRDemo.extractTextFromAreas(path+"/"+pngFileNames.get(0));
					System.out.println("OCR Map: " + ocrMap);
					
					for (Object value : ocrMap.values()) {
					    if (value == null || "".equals(value.toString().trim())) {
					        response.put("errorMessage", "필수 항목은 반드시 기재되어야 합니다.");
					        return response;
					    }
					}
				
					
					 int n = service.careerInsert(ocrMap); if(n>0) {
						 System.out.println("insert 성공!!!!!");
					 }
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			/*
			 * model.addAttribute("originFileName",originalFileName);
			 * model.addAttribute("saveFileName",pngFileNames); model.addAttribute("path",
			 * path);
			 */
		}
		
		return response;
	}
	

}
