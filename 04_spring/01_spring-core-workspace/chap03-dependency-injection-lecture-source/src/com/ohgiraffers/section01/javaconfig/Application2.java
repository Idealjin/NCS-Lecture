package com.ohgiraffers.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ohgiraffers.section01.javaconfig.config.ContextConfiguration2;

public class Application2 {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration2.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
		
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().deposit(1000000));
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().withDraw(50000));
		System.out.println(member.getPersonalAccount().getBalance());
		
	}
}
