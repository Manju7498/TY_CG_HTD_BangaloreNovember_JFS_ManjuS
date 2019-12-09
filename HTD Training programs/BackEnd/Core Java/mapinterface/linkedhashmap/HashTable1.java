package com.cg.map.linkedhashmap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
public class HashTable1 {
	public static void main(String[] args) {
		Hashtable<Integer,String> h=new Hashtable<Integer,String>();
		h.put(518,"manju");
		h.put(216,"gayathri");
		h.put(465,"amulya");
		Set<Map.Entry<Integer,String>> s=h.entrySet();
		for (Map.Entry<Integer, String> e : s) {
			System.out.println("key : "+e.getKey()+" & value : "+e.getValue());
		}
		System.out.println(h.isEmpty());
		System.out.println(h.containsKey(518));
		System.out.println(h.containsValue("manju"));
	}
}
