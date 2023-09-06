package com.visa.prj.client;

import com.visa.prj.entity.Book;

public class BookClient {

	public static void main(String[] args) {
		Book javaBook = new Book("Head First Java", 540.00);
		Book reactBook = new Book("React Ref", 890.11);
		
		javaBook.setPrice(578.00);
		
		System.out.println("Title :" + javaBook.getTitle());
		System.out.println("Price : " + javaBook.getPrice());
		
		System.out.println(reactBook); // object as argument toString() Object class
	}

}
