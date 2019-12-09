package com.cpgm.access.pack1;

public class Student {
	protected String sname;
	protected Student(String name ) {
		sname=name;
	}
	protected  void sdetails() {
		System.out.println("student is "+sname);
	}
}
