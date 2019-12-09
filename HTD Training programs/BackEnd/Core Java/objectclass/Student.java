
public class Student {
	int id;
	String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
public String toString() {
	return "student id is : " +id+" student name is :" +name;
}
public static void main(String[] args) {
	Student s=new Student(18,"manju");
	System.out.println(s.toString());
}
}
