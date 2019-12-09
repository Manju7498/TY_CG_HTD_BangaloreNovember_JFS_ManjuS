
public class Student1 implements Comparable<Student1> {
	String name;
	int age;
	public Student1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student1 [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student1 o) {
		if(this.age > o.age) {
			return 1;
		}
		else if(this.age > o.age) {
			return -1;
		}else {
		return 0;
		}
	}

}
