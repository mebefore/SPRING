package com.spring.anotation;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.junit.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class BeanTest {
	//junit 테스트 해보기
	@Test
	public void test() {
		System.out.println("단순 테스트");
	}
	@Autowired
	ApplicationContext ctx;
	
	//@Test
	public void createBeanTest() {
		TV tv = (TV)ctx.getBean("tv");
		assertNotNull(tv);
	}
	
	//바깥에서 restaurant 필드로 선언한 후 
	@Autowired
	Restaurant res;
	
	//그 필드로 직접 테스트 
	@Test
	public void createRestaurantTest() {
		res.open();
	}
	
	
}
