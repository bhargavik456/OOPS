package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;

import com.visa.prj.entity.Product;

public class SetExample {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("Jack");
		names.add("Peter"); // hashCode()
		names.add("Larry"); // hashCode()
		names.add("Anna"); // hashCode()
		names.add("Jack"); // ignored --> hashCode() and equals()
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Set<Product> products = new HashSet<>();
		products.add(new Product(553, "LG AC", 45000.00, "electrical"));
		products.add(new Product(81, "Macbook Pro", 245000.00, "computer"));
		products.add(new Product(553, "iPhone 14", 89000.00, "mobile"));
		products.add(new Product(61, "OnePlus Nord", 75000.00, "mobile"));
		products.add(new Product(135, "Sony Bravia", 295000.00, "tv"));
		products.add(new Product(5453, "Logitech Mouse", 800.00, "computer"));
		products.add(new Product(81, "Macbook Pro", 245000.00, "computer")); // duplicate
		
		for (Product p : products) {
			System.out.println(p); // toString() @Data
		}
		

	}

}
