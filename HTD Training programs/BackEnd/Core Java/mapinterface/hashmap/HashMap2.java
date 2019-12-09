package com.cg.map.hashmap;

import java.util.Collection;
import java.util.HashMap;

public class HashMap2 {

	public static void main(String[] args) {
		HashMap<Integer,Student> h=new HashMap<Integer,Student>();
		h.put(2,new Student(18,"manju"));
		h.put(76,new Student(16,"gayathri"));
		h.put(34,new Student(9,"chinni"));
		h.put(76,new Student(18,"manju"));
		h.put(93,new Student(5,"amulya"));
		h.put(null,null);
		h.put(null,new Student(25,"pranitha"));
		Collection<Student> c=h.values();
		for (Student s : c) {
			System.out.println("Student ID:"+s.id+" Student Name:"+s.name);
		}
		System.out.println(h.containsKey(93));
		System.out.println(h.containsValue(new Student(18,"manju")));
		System.out.println(h.get(34));
	}

}
