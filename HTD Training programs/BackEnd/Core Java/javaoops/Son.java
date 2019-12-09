package javaOops;

public class Son extends Father {
	Son() {
		super("name",15);
		System.out.println("C");
	}
	Son(String name,int age) {
		this();
		System.out.println("D");
	}


}
