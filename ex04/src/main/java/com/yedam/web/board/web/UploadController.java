package com.yedam.web.board.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@Value("${file.upload.path}")
	private String uploadPath; //특정 필드 위에 value 어노테이션 사용 - 외부값 들고옴
	

	//페이지
	@GetMapping("upload") //페이지라서 get 방식 - 페이지 불러 올 거임 
	public void getUploadPage() {}
	
	
	//처리
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) { //multipart가 실행되려면 multipartresolver 따로 등록 해줘야함 
	    //다중값이라 multipart에 배열쓰고 for문이 쓰인다.
		List<String> imageList = new ArrayList<>();
		
	    for(MultipartFile uploadFile : uploadFiles){
	    	if(uploadFile.getContentType().startsWith("image") == false){ //파일 형식이 image인지 확인하는 코드 
	    		System.err.println("this file is not image type");
	    		return null;
	        }
	  
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1); //사용자가 파일 업로드 요청할 때 보내는 정보 중 파일이 무언지 판별하는 코드 (?)
	        //업로드 파일의 오리지널네임 확인 후 중간 경로 있으면 제외시킴 
	        
	        System.out.println("fileName : " + fileName); //오리지널 네임 갖고옴 
	    
	        //파일 이름 중 중복되는 파일 걸러주는  작업  
	        
	        //날짜 폴더 생성
	        String folderPath = makeFolder();
	        
	        //UUID
	        String uuid = UUID.randomUUID().toString(); // 시간 기준으로 유니크값 끌고오기 (시간 = 유니크한 값, long타입으로 처리하면 중복값 나올 수 없기에)
	        
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분	        
	        String uploadFileName = folderPath +File.separator + uuid + "_" + fileName; 
	        
	        String saveName = uploadPath + File.separator + uploadFileName;
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        
	        System.out.println("path : " + saveName); //업로드할 땐 path타입으로 업로드 진행해야한다.
	        try{
	        	uploadFile.transferTo(savePath);
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        imageList.add(setImagePath(uploadFileName));
	     }
	    //db에 저장
	    //db저장 시 풀네임 사용하면 안 된다.
	    //- uploadFileName
	    
	    
	    return imageList;
	}
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); //오늘 날짜 갖고옴 
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator); //파일 안에 폴더를 나누는 기준, 자바가 인식하는 기준으로 change시킴, 슬러시를?
		File uploadPathFoler = new File(uploadPath, folderPath);//이폴더 밑에 모든 업로드 파일을 모을 것이다. 
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) { //실존 확인 코드 
			uploadPathFoler.mkdirs(); //없으면 생성하라
			
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath; //생성 완료되면 folderPath 반환 
	}
	
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}
}
