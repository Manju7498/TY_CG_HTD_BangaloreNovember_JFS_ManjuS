package com.cg.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean,DisposableBean{
	public Hello() {
		System.out.println("Object created");
	}
	public Hello(String message, int count) {
		super();
		this.message = message;
		this.count = count;
	}

	private String message;
	private int count;
	//disposable
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}
               //method present in disposable bean
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	/*
	 * @Override public void afterPropertiesSet() throws Exception {
	 * System.out.println("properties");
	 * 
	 * }
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

}
