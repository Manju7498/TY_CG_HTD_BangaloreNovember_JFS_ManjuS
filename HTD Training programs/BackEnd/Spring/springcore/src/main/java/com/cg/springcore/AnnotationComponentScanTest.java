package com.cg.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.springcore.beans.Animal;
import com.cg.springcore.beans.Pet;
import com.cg.springcore.config.ComponentScanConfig;

public class AnnotationComponentScanTest {
	public static void main(String[] args) {
		ApplicationContext context=new 
				AnnotationConfigApplicationContext(ComponentScanConfig.class);
		Animal animal=context.getBean(Animal.class);
		animal.makeSound();
		Pet pet=context.getBean(Pet.class);
		pet.getAnimal().makeSound();
	}

}
