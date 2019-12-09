import java.util.TreeSet;

public class TreeSet2 {

	public static void main(String[] args) {
		TreeSet<Student1> t=new TreeSet<Student1>();
		t.add(new Student1("manju",21));
		t.add(new Student1("gayathri",22));
		t.add(new Student1("manju",21));
		for (Student1 s : t) {
			System.out.println(s.name+" and age is "+s.age);
		}
	}

}
