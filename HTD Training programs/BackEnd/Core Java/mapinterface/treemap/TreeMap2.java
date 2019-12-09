package com.cg.map.treemap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
public class TreeMap2 {
	public static void main(String[] args) {
		SortingAge s1=new SortingAge();
		SortingName s2=new SortingName();
		TreeMap<Student,String> t=new TreeMap<Student,String>(s2);
		t.put(new Student("gayathri",5),"2st Standard");
		t.put(new Student("manju",4),"1st Standard");
		t.put(new Student("pranitha",6),"3st Standard");
		Set<Map.Entry<Student,String>> s=t.entrySet();
		for (Map.Entry<Student, String> e : s) {
			System.out.println("key : "+e.getKey()+" Value : "+e.getValue());
		}
		System.out.println(t.get(new Student("gayathri",5)));
	}

}
