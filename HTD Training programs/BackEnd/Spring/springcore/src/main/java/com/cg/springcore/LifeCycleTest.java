package com.cg.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.springcore.beans.Hello;

public class LifeCycleTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
		Hello hello = context.getBean(Hello.class);
		System.out.println(hello.getMessage());
		System.out.println(hello.getCount());
		context.close();
	}

}
