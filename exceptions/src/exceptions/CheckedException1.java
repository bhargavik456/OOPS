package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException1 {

	public static void main(String[] args) {
		System.out.println("start!!!");
		doTask();
	}

	private static void doTask() {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			// logic
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
