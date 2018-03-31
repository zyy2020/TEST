package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.SJXZDao;
import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;

public class SJXZTest {
	private static SJXZDao sjxzDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		sjxzDao = new SJXZDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		XuanZe xuanZe = new XuanZe();
		xuanZe.setId(1);
	    List<SJXZ>sjxzs = new ArrayList<SJXZ>();
	    sjxzs.add(new SJXZ(shiJuan, xuanZe));		
		int insertSJXZ = sjxzDao.insertSJXZ(sjxzs);
		System.out.println(insertSJXZ);
	}

	@Test
	public void select() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		List<XuanZe> listXuanZes = sjxzDao.selectByShiJuanId(shiJuan);
		for (XuanZe xuanZe : listXuanZes) {
			System.out.println(xuanZe);
		}
	}

	@Test
	public void update() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		XuanZe xuanZe = new XuanZe();
		xuanZe.setId(1);
		SJXZ sjxz = new SJXZ(shiJuan, xuanZe);
		int updateByShiJuanId = sjxzDao.updateByShiJuanId(sjxz);
		System.out.println(updateByShiJuanId);
	}

	@Test
	public void delete() throws SQLException {
		int del = sjxzDao.deleteByShiJuanId(1, 1);
		System.out.println(del);
	}
}
