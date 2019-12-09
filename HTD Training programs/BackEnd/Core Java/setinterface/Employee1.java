
public class Employee1 implements Comparable<Employee1> {
	int empId;
	int empAge;
	String empName;
	public Employee1(int empId, int empAge, String empName) {
		super();
		this.empId = empId;
		this.empAge = empAge;
		this.empName = empName;
	}
	@Override
	public int compareTo(Employee1 o) {
		return o.empName.compareTo(this.empName);
	}
	
}
