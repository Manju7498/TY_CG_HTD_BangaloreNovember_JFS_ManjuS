package javaOops;

public class TestStudent {
	public static void main(String[] args) {
		Student s=new Student();
		System.out.println("name is "+s.studName+" age is "+s.studAge);
		Student s1=new Student("manju",21);
		System.out.println("name is "+s1.studName+" age is "+s1.studAge);
		
	}

}
