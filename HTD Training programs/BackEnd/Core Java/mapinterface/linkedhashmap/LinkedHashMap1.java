package com.cg.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap1 {
	

	public static void main(String[] args) {
		LinkedHashMap<String,Integer> l=new LinkedHashMap<String,Integer>();
		l.put("BTM",560076);
		l.put("BTR",560073);
		l.put("RAJAJINAGAR",567004);
		l.remove("BTR");
		Set<Map.Entry<String,Integer>> s=l.entrySet();
		for (Map.Entry<String, Integer> e : s) {
			System.out.println("key:"+e.getKey()+" Value:"+e.getValue());
		}
		System.out.println("size : "+l.size());
		System.out.println("key : "+l.containsKey("BTM"));
		System.out.println("value : "+l.containsValue("567004"));
		System.out.println("empty : "+l.isEmpty());
 	}

}
