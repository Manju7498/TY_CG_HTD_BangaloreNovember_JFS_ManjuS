package com.cg.springcore.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorClass implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, 
			String beanName) throws BeansException {
		System.out.println("before init : "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean,
			String beanName) throws BeansException {
		System.out.println("after init : "+beanName);
		return bean;
	}
}
