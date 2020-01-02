package com.cg.springcore.beans;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
	@Override
	public void makeSound() {
		System.out.println("bowww bowww");
	}

}
