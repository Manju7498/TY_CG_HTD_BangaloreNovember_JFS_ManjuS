package accessSpecifier;

public class Person {
	private String name;
	Person(String name) {
		this.name=name;
	}
	 private  void display() {
		 System.out.println("name is "+name);
	 }

}
