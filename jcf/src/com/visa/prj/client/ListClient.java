package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.visa.prj.entity.Product;

public class ListClient {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(553, "LG AC", 45000.00, "electrical"));
		products.add(new Product(81, "Macbook Pro", 245000.00, "computer"));
		products.add(new Product(553, "iPhone 14", 89000.00, "mobile"));
		products.add(new Product(61, "OnePlus Nord", 75000.00, "mobile"));
		products.add(new Product(135, "Sony Bravia", 295000.00, "tv"));
		products.add(new Product(5453, "Logitech Mouse", 800.00, "computer"));

		Collections.sort(products); // Comparable as in Product.java

		System.out.println("****");
		for (Product p : products) {
			System.out.println(p); // toString() @Data
		}
		System.out.println("****");

		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())); // Comparator
		System.out.println("****");
		for (Product p : products) {
			System.out.println(p); // toString() @Data
		}
		System.out.println("****");
	}

}
