package com.cg.map.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap2 {

	public static void main(String[] args) {
		LinkedHashMap<Integer,Employee> l=new LinkedHashMap<Integer,Employee>();
		l.put(23,new Employee(518,"manju"));
		l.put(93,new Employee(216,"gayathri"));
		l.put(86,new Employee(534,"syamala"));
		Set<Map.Entry<Integer,Employee>> s=l.entrySet();
		for (Map.Entry<Integer, Employee> e : s) {
		System.out.println("key : "+e.getKey()+" value : "+e.getValue());
		}
	}
}
