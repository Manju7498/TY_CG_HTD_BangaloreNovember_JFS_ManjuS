package com.cg.map.treemap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
public class TreeMap3 {
	public static void main(String[] args) {
      ArrayList<Student1> a=new ArrayList<Student1>();
      a.add(new Student1("Manju",518));
      a.add(new Student1("Gayathri",216));
      ArrayList<Student1> a1=new ArrayList<Student1>();
      a1.add(new Student1("Chinni",209));
      a1.add(new Student1("bhargavi",224));
      ArrayList<Student1> a2=new ArrayList<Student1>();
      a2.add(new Student1("Amulya",405));
      a2.add(new Student1("monika",426));
      TreeMap<String,ArrayList<Student1>> t=new TreeMap<String,ArrayList<Student1>>();
      t.put("3rd standard",a);
      t.put("9th standard",a1);
      t.put("8th standard",a2);
      Set<Entry<String, ArrayList<Student1>>> s=t.entrySet();
		for (Map.Entry<String, ArrayList<Student1>> e : s) {
			System.out.println("key : "+e.getKey()+" Value : "+e.getValue());
		}
	}

}
