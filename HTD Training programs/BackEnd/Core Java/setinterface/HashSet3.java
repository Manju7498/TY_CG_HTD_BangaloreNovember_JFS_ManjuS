import java.util.HashSet;

public class HashSet3 {

	public static void main(String[] args) {
		HashSet<Student> h=new HashSet<Student>();
		h.add(new Student("manju", 21));
		h.add(new Student("gayathri", 22));
		h.add(new Student("manju", 21));
		
		for (Student s : h) {
			System.out.println("Student name is "+s.studName+" and age is "+s.studAge);
			System.out.println(s.hashCode());
		}

		
	}

}
