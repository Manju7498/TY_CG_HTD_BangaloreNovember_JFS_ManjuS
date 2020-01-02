package com.cg.di.factory;

import com.cg.di.dao.Animal;
import com.cg.di.dao.Dog;

public class AnimalFactory {
	private AnimalFactory() {
		
	}
	public static Animal getAnimal() {
		return new Dog();
	}
}
