package javaOops;

public class Person {
	static int age;
	String name;
	void personDetails()
	{
		System.out.println("Person name is "+name+" and age is "+age);
		personDetailsStatic();
		
	}
	static void personDetailsStatic()
	{
		System.out.println(age);
	}
	

}
