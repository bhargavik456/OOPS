package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public class MobileDaoDBImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		System.out.println("SQL store .." + m.getName());
	}

}
