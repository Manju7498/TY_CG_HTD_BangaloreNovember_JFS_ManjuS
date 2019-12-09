import java.util.TreeSet;

public class TreeSet3 {

	public static void main(String[] args) {
		//EmployeeName e1=new EmployeeName();
		TreeSet<Employee1> t=new TreeSet<Employee1>();
		t.add(new Employee1(518,21,"manju"));
		t.add(new Employee1(216,22,"gayathri"));
		t.add(new Employee1(518,21,"manju"));
		for (Employee1 s : t) {
			System.out.println("EmpID : "+s.empId+" Employee Name : "+s.empName+" Employee age : "+s.empAge);
		}
	}
}

