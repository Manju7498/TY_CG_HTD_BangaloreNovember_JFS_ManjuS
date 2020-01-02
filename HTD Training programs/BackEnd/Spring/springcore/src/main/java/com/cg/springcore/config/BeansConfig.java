package com.cg.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.cg.springcore.beans.Cat;
import com.cg.springcore.beans.Dog;
import com.cg.springcore.beans.Hello;
import com.cg.springcore.beans.Pet;

@Configuration
public class BeansConfig {
	@Bean("hello")
	@Scope("prototype")
	public Hello getHello() {
		Hello hello=new Hello();
		hello.setMessage("I love Jackie chan");
		hello.setCount(7);
		return hello;
	}
	@Bean(name="dog")           //by default id is methodname(getDog)
	public Dog getDog() {
		return new Dog();
	}
	@Bean("pet")
	public Pet getPet() {
		Pet pet=new Pet();
		pet.setName("Doggy");
		//pet.setAnimal(getDog());
		return pet;
	}
	@Bean("cat")
	@Primary
	public Cat getCat() {
		return new Cat();
	}
	
}
