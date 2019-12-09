package javaOops;

public class Father {
	String fatherName;
	int fatherAge;
	Father() {
		System.out.println("A");
	}
	Father(String name,int age) {
		this();
		System.out.println("B");
	}


}
