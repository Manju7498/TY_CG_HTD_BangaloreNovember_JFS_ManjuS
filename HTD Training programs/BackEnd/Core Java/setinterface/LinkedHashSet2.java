import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 {

	public static void main(String[] args) {
		LinkedHashSet<Employee> l1=new LinkedHashSet<Employee>();
		l1.add(new Employee(518,"manju"));
		l1.add(new Employee(216,"gayathri"));
		l1.add(new Employee(518,"manju"));
		Iterator<Employee> itr=l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
