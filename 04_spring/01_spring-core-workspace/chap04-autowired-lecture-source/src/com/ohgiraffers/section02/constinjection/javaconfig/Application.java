package com.ohgiraffers.section02.constinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ohgiraffers.section02.constinjection.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		MakeRandomString randomString = context.getBean(MakeRandomString.class);
		
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		
	}
	
}
