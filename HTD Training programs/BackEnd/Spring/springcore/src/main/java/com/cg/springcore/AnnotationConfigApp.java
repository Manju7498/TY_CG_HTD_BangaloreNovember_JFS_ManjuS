package com.cg.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.springcore.beans.Animal;
import com.cg.springcore.beans.Dog;
import com.cg.springcore.beans.Hello;
import com.cg.springcore.beans.Pet;
import com.cg.springcore.config.BeansConfig;

public class AnnotationConfigApp {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(BeansConfig.class);
		Hello hello=context.getBean(Hello.class);
		System.out.println(hello.getMessage());
		System.out.println(hello.getCount());
		System.out.println("*********************");
		Hello hello1=context.getBean(Hello.class);
		System.out.println(hello);
		System.out.println(hello1);
		System.out.println(hello==hello1);
		System.out.println("**********************");
		Animal animal=context.getBean(Dog.class);
		animal.makeSound();
		System.out.println("**********************");
		Pet pet=context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		
	}

}
