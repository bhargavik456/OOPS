package com.visa.prj.client;

import java.util.Arrays;
import java.util.Comparator;

//class LengthComparator implements Comparator<String> {
//
//	@Override
//	public int compare(String o1, String o2) {
//		return o1.length() - o2.length();
//	}
//	
//}
public class SortClient {

	public static void main(String[] args) {
		String[] names = { "Johnny", "George", "Angelina", "Scarlett", "Penelope", "Brad" };

		Arrays.sort(names);

		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("**********");

//		Arrays.sort(names, new LengthComparator());
//		Arrays.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
////				System.out.println(o1 + ", " + o2);
//				return o1.length() - o2.length();
//			}	
//		});
		
		Arrays.sort(names, (o1, o2) ->  o1.length() - o2.length());
		
		for (String name : names) {
			System.out.println(name);
		}
	}

}
