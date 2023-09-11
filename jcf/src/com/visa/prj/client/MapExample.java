package com.visa.prj.client;

import java.util.Map;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {
		//Map<String, Double> bookData = new HashMap<>();
//		Map<String, Double> bookData = new HashMap<>(10, 0.7f); // initial size is 10, load factor is 70%
//		Map<String, Double> bookData = new TreeMap<>(); // default uses Comparable
		// using Comparator --> Red Black Tree
		Map<String, Double> bookData = new TreeMap<>((s1, s2) ->  {
			int diff = s1.length() - s2.length();
			if(diff == 0) {
				diff = s1.compareTo(s2); // string compare
			}
			return diff;
		}); // comparator
		
		bookData.put("Java", 890.00);
		bookData.put("Oracle", 1234.21);
		bookData.put("React", 890.00);
		
		bookData.put("Oracle", 988.00); // over write
		bookData.put("JS", 888.00);
		bookData.put("MySQL", 888.00);
		System.out.println(bookData.get("React")); // 890.00
		
		bookData.forEach((key,value) -> {
			System.out.println(key + " : " + value);
		});
	}

}
