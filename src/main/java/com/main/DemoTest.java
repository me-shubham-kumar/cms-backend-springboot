package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")//to scan RestController,Service and Repository
@EntityScan(basePackages = "com")//to scan Entity classes
public class DemoTest {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoTest.class, args);
		System.out.println("Spring boot is ready");
		//Testing testing = new Testing();
		//System.out.println(testing.saveUser());
	/*AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
	acac.scan("com");

	acac.refresh();
	Testing tt = (Testing)acac.getBean("testing");
	System.out.println(tt.saveUser());
	*/
		//System.out.println("Testing called");
	}
}
