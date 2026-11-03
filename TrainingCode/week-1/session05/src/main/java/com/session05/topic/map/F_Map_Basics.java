package com.session05.topic.map;

import java.util.*;
import java.util.Map.Entry;

public class F_Map_Basics {

	public static void main(String[] args) {
		//map, hashtable, map,
		//map key value
		Map<String, Integer> map = new TreeMap<>();//HashMap, LinkedHashMap, TreeMap
		map.put("ekta", 80);
		map.put("raj", 84);
		map.put("raj", 90);
		//map.putIfAbsent("ekta", 88);
		map.put("gunika", 99);
		System.out.println("printing the map");
		System.out.println(map.get("ekta"));

		//System.out.println(map);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key=iterator.next();
			System.out.println(key + " : "+ map.get(key));
		}
		//Itrating map using entryset
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}

		// how to print the map
	}
}
