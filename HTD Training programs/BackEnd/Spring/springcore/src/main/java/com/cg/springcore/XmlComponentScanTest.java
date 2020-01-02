package com.cg.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.springcore.beans.Animal;
import com.cg.springcore.beans.Pet;

public class XmlComponentScanTest {
	public static void main(String[] args) {
		ApplicationContext context=new 
				ClassPathXmlApplicationContext("spring.xml");
		Animal animal=context.getBean(Animal.class);
		animal.makeSound();
		Pet pet=context.getBean(Pet.class);
		pet.getAnimal().makeSound();
	}

}
