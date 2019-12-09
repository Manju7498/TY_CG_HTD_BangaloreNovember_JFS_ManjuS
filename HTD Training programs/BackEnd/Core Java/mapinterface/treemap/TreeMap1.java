package com.cg.map.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {

	public static void main(String[] args) {
		TreeMap<Integer,String> t=new TreeMap<Integer,String>();
		t.put(23,"Manju");
		t.put(76,"Uday");
		t.put(54, "Chaitra");
		Set<Map.Entry<Integer,String>> s=t.entrySet();
		for (Map.Entry<Integer, String> e : s) {
			System.out.println("key : "+e.getKey()+" Value : "+e.getValue());
		}
	}

}
