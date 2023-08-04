package com.yedam.web;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EncryptionTest {

	@Autowired
	StandardPBEStringEncryptor encryptor; 
	//등록된 database xml 안의 두번째 bean의 클래스 이름 갖고옴
	
	@Test
	public void encryptionTest() {
		String[] dataList = {
								""
								,""
								,""
								,""
							};
		//""안에 암호화 해야할 값들 입력
		//
		for(String data : dataList) {
			String encData = encryptor.encrypt(data); //암호화 : encrypt, 암호화 해석 : decrypt
			System.out.println(encData);
		}
	}
}
