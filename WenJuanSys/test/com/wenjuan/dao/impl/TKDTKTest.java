package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.TianKongDTKDao;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;

public class TKDTKTest {
	private static TianKongDTKDao tianKongDTKDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		tianKongDTKDao = new TKDTKDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		TKDTK tkdtk = new TKDTK(2, 1, 1, "HDJS");
		List<TKDTK> tkdtks = new ArrayList<TKDTK>();
		tkdtks.add(tkdtk);
		int insertTKDTK = tianKongDTKDao.insertTKDTK(tkdtks);
		System.out.println(insertTKDTK);
	}

	@Test
	public void selectByShiJuan() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		List<TKDTK> selectTKDTK = tianKongDTKDao.selectTKDTK(shiJuan,5);
		for (TKDTK tkdtk : selectTKDTK) {
			System.out.println(tkdtk);
		}
	}

	@Test
	public void selectByUser() throws SQLException {
		User user = new User();
		user.setId(1);
		List<TKDTK> selectTKDTK = tianKongDTKDao.selectTKDTK(user);
		for (TKDTK tkdtk : selectTKDTK) {
			System.out.println(tkdtk);
		}
	}

}
