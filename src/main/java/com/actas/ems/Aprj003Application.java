package com.actas.ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.actas.ems.Mapper") //service에서 dto를 못잡아서 명시적으로 주소를 할당함

public class Aprj003Application{

	public static void main(String[] args) {
		SpringApplication.run(Aprj003Application.class, args);
	}


}
