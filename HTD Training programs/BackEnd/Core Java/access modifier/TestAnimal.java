package com.cpgm.typecasting.pack3;

public class TestAnimal {
	public static void main(String[] args) {
		Animal a=new Animal();
		a.eat();
		System.out.println("************");
		Animal a1=new Lion();
		a1.eat();
		System.out.println("************");
		Animal a2=new Dog();
		a1.eat();
		System.out.println("************");
		Dog d=(Dog)a2;
		d.eat();
		d.walk();
		System.out.println("**************");
		Lion l1=(Lion) a1;
		l1.eat();
		l1.run();
		System.out.println("************");
	
	}

}
