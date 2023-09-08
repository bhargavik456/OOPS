package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.Utility;

public class SortClient {

	public static void main(String[] args) {
		String[] names = { "Johnny", "George", "Angelina", "Scarlett", "Penelope", "Brad" };
		Utility.sort(names);
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Product[] products = new Product[4]; // Array of Pointers
		products[0] = new Mobile(345, "iPhone 14", 89000.00, "4G"); // up casting
		products[1] = new Tv(42, "Onida KyThunder", 3500.00, "CRT"); // up casting
		products[2] = new Tv(62, "Sony Bravia", 2_35_000.00, "OLED");
		products[3] = new Mobile(922, "Samsung Fold", 129000.00, "4G");
		
		Utility.sort(products);
		
		for(Product p : products) {
			System.out.println(p.getName() + ", " + p.getPrice());
		}
	}

}
