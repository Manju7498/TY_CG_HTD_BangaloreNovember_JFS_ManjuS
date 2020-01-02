package com.cg.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.springcore.beans.Animal;
import com.cg.springcore.beans.Hello;
import com.cg.springcore.beans.Pet;
public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
		Hello hello=context.getBean(Hello.class);
		Hello hello1=context.getBean(Hello.class);
		System.out.println("***************");
		System.out.println(hello);
		System.out.println(hello1);
		System.out.println(hello==hello1);
		System.out.println(hello.getMessage());
		System.out.println(hello.getCount());
		System.out.println("***************");
		Animal animal=context.getBean(Animal.class);//Dependency in interfaces
		animal.makeSound();
		Pet pet=context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		
		
	}
}
