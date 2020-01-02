package com.cg.di;

import com.cg.di.dao.Animal;
import com.cg.di.factory.AnimalFactory;

public class App {
	public static void main(String[] args) {
		Animal animal=AnimalFactory.getAnimal();
		//getAnimal()-injecting the dependencies of dog into app.java
		animal.makeSound();
	}

}
