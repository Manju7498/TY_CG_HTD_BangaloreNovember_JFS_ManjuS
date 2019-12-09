package com.cg.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMap1 {

	public static void main(String[] args) {
		HashMap<Integer,String> h=new HashMap<Integer,String>();
		h.put(18,"manju");
		h.put(null, null);
		h.put(16,"gayathri");
		h.put(9,"chinni");
		h.put(24,"bhargavi");
		h.put(5,"amulya");
		h.put(9,"chinni");
		h.put(null, null);
		Set<Map.Entry<Integer,String>> s=h.entrySet();
		for (Map.Entry<Integer, String> e : s) {
			System.out.println("key : "+e.getKey()+" &  Value : "+e.getValue());
		}
	}

}
