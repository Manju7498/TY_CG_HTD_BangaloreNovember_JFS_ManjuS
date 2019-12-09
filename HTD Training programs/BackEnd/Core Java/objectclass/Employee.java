
public class Employee {
	int id;
	String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "employee name is "+name+"  Employee id is "+id;
	}
	public static void main(String[] args) {
		Employee e=new Employee(18,"manju");
		System.out.println(e.hashCode());
		Employee e1=new Employee(16,"gayathri");
		System.out.println(e1.hashCode());
		System.out.println(e);

	}

}
