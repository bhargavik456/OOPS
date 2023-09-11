package exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedException2 {

	public static void main(String[] args) {
		System.out.println("start!!!");
		doTask();
	}

	private static void doTask() {
		try {
			Connection con = DriverManager.getConnection("IPADDRESS , PORT");// connect to db
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
