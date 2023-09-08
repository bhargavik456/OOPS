package com.visa.prj.util;

public class Utility {
	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				if(elems[i].compareTo(elems[j]) > 0) {
					Comparable elem = elems[i];
					elems[i] = elems[j];
					elems[j] = elem;
				}
			}
		}
	}
}

