package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.SJTKDao;

import com.wenjuan.bean.SJTK;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TianKong;

public class SJTKTest {
	private static SJTKDao sjtkDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		sjtkDao = new SJTKDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		List<SJTK>sjtks=new ArrayList<SJTK>();
		for(int i=0;i<2;i++) {
			ShiJuan shiJuan = new ShiJuan();
			TianKong tianKong = new TianKong();
			shiJuan.setId(i+1);
			tianKong.setId(1);
			SJTK sjtk = new SJTK(shiJuan, tianKong);
			sjtks.add(sjtk);
		}
		int insertSJTK = sjtkDao.insertSJTK(sjtks);
		System.out.println(insertSJTK);
	}

	@Test
	public void select() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		List<TianKong> listTKs = sjtkDao.selectByShiJuanId(shiJuan);
		for (TianKong tianKong : listTKs) {
			System.out.println(tianKong);
		}
	}

	@Test
	public void update() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		TianKong tianKong = new TianKong();
		tianKong.setId(1);
		SJTK sjtk = new SJTK(shiJuan, tianKong);
		int up = sjtkDao.updateSJTK(sjtk);
		System.out.println(up);
	}

	@Test
	public void delete() throws SQLException {
		int del = sjtkDao.deleteSJXZ(1, 1);
		System.out.println(del);
	}
}
