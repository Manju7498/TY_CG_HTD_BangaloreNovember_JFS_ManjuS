package javaOops;

public class TestPerson1 {
	public static void main(String[] args) {
		Person1 p1=new Person1();
		p1.age=20;
		p1.name="MANJU";
		p1.details();
		Person1 p2=new Person1();
		p2.initialize(21, "Syamala");
		p2.details();
	}

}
