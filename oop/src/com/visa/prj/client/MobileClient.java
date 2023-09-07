package com.visa.prj.client;

import com.visa.prj.dao.MobileDao;
import com.visa.prj.dao.MobileDaoFactory;
import com.visa.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		Mobile m = new Mobile(345, "iPhone 14", 89000.00, "4G"); 
		
//		MobileDao mobileDao = new MobileDaoDBImpl();
//		MobileDao mobileDao = new MobileDaoMongoImpl();
		
		MobileDao mobileDao = MobileDaoFactory.getMobileDao();
		mobileDao.addMobile(m);
	}

}
