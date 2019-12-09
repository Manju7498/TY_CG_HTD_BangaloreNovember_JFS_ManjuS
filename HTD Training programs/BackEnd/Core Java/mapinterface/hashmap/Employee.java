package com.cg.map.hashmap;

public class Employee {
	int EmpId;
	String EmpName;
	public Employee(int empId, String empName) {
		super();
		EmpId = empId;
		EmpName = empName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EmpId;
		result = prime * result + ((EmpName == null) ? 0 : EmpName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (EmpId != other.EmpId)
			return false;
		if (EmpName == null) {
			if (other.EmpName != null)
				return false;
		} else if (!EmpName.equals(other.EmpName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + "]";
	}
	

}
