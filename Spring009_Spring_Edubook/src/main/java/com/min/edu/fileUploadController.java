package com.min.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

@Controller
public class fileUploadController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/uploadForm.do")
	public String fileuploadForm() {
		logger.info("Welcome fileUploadController 파일업로드");
		return "uploadForm";
	}
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, Model model,
							List<MultipartFile> file, String desc) {
		System.out.println(file.size());
		System.out.println(desc);
		
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
			
			model.addAttribute("originFileName",originalFileName);
			model.addAttribute("saveFileName",saveFileName);
			model.addAttribute("path", path);
		}
		
		return "uploadFile";
	}
	
	@RequestMapping(value = "/download.do", method = RequestMethod.POST)
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, //절대경로(물리적인 주소)
								HttpServletResponse response, //header 정보
								String originFileName, //화면에서 보여지는 파일명
								String saveFileName //저장되어 있는 물리적인 파일명
			) throws IOException {
		// 파일 다운로드를 위한 물리적인 주소(가상으로 배포된 물리적인 주소)
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		
		// 물리적인 주소에서 선택한 파일을 File객체로 만듦
		File file = new File(path+"/"+saveFileName);
		
		//물리적인 주소의 파일을 byte[]로 복제함
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		//파일명을 Encoding
//		String outputFileName = new String(file.getName().getBytes(),"8859_1");
		String outputFileName = new String(originFileName.getBytes(),"8859_1");
		
		//브라우저가 데이터를 어떻게 처리할지를 알려줘야함. Header 정보
		response.setHeader("Content-Disposition", "attachment; filename=\""+outputFileName+"\"");
		
		//브라우저에게 현재 데이터를 처리할 방식
		response.setContentLength(bytes.length);
		response.setContentType("application/octet-stream");
		
		return bytes;
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax.do", method = RequestMethod.POST)
	public Map<String, Object> fileUploadAjax(HttpServletRequest request, Model model,
												List<MultipartFile> file, String desc) {
		
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
			
			model.addAttribute("originFileName",originalFileName);
			model.addAttribute("saveFileName",saveFileName);
			model.addAttribute("path", path);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isc", "test");
		return map;
	}
}
