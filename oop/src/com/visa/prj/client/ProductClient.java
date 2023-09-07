package com.visa.prj.client;

import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[4]; // Array of Pointers
		products[0] = new Mobile(345, "iPhone 14", 89000.00, "4G"); // up casting
		products[1] = new Tv(42, "Onida KyThunder", 3500.00, "CRT"); // up casting
		products[2] = new Tv(62, "Sony Bravia", 2_35_000.00, "OLED");
		products[3] = new Mobile(922, "Samsung Fold", 129000.00, "4G");
//		products[4] = new Product(988, "Dummy", 0.00);
		printExpensive(products);

		printDetails(products);

		System.out.println("OCP output-->");
		printOCPWay(products);
	}

	// OCP
	private static void printOCPWay(Product[] products) {
		for (Product p : products) {
			Method[] methods = p.getClass().getMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get")) {
					try {
						// p.getConnectivity();
						Object ret = m.invoke(p);
						System.out.println(m.getName().substring(3).toUpperCase() +  " : " + ret);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.out.println("*****");
		}
	}

	// OCP?
	private static void printDetails(Product[] products) {
		for (Product p : products) {
			System.out.println(p.getName() + ", " + p.getPrice());
			if (p instanceof Mobile) {
				Mobile m = (Mobile) p; // down casting
				System.out.println(m.getConnectivity());
			} else if (p.getClass() == Tv.class) {
				Tv t = (Tv) p; // down casting
				System.out.println(t.getScreenType());
			}
		}
	}

	// OCP
	private static void printExpensive(Product[] products) {
		for (Product p : products) {
			if (p.isExpensive()) { // Polymorphic, dynamic binding
				System.out.println(p.getName() + " is expensive!!");
			} else {
				System.out.println(p.getName() + " is not expensive!!");
			}
		}
	}

}
