package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public class MobileDaoMongoImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		System.out.println("MongoDB Store ..." + m.getName());
	}

}

