
public class Employee1 {
	String name;
	int id;
	public Employee1(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public boolean equals(Object obj) {
		Employee e1=(Employee)obj;
		if(e1.id==this.id) {
		        if(e1.name.equals(this.name)) {
			      return true;
		         }else {
			      return false;
		                }
	          }
		else {
			return false;
		}
	}
public static void main(String[] args) {
	Employee e1=new Employee(18,"manju");
	Employee e2=new Employee(18,"manju");
	System.out.println(e1.equals(e2));
	System.out.println(e1.hashCode());
	System.out.println(e2.hashCode());
	
}
@Override
public int hashCode() {
	return 10;
	/*final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;*/
}
/*
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee1 other = (Employee1) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}*/
}
