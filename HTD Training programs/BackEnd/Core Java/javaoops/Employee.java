package javaOops;

public class Employee {
	String empName;
	int empAge;
	double empSal;
	Employee(String n,int a,double s) {
		empName=n;
		empAge=a;
		empSal=s;
	}
	void details() {
		System.out.println("Employee name is "+empName+" and age is "+empAge+" and salary is "+empSal);
	}
	

}
