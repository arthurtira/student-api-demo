package com.arthurtira.studentapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiDemoApplication.class, args);
	}

}
