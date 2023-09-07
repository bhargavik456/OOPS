package com.visa.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	// factory method
//	public static MobileDao getMobileDao() {
//			return new MobileDaoDBImpl();
//	}

	private static String DAO = "";

	static {
		ResourceBundle res = ResourceBundle.getBundle("config");
		DAO = res.getString("DAO_CLASS");
	}

	public static MobileDao getMobileDao() {
		try {
			return (MobileDao) Class.forName(DAO).getDeclaredConstructor().newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
