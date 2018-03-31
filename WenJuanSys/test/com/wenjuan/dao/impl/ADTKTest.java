package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.bean.ADTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.User;
import com.wenjuan.dao.AskDTKDao;

public class ADTKTest {
	private static AskDTKDao askDTKDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		askDTKDao = new ADTKDaoImpl();
	}

	@Test
	public void add() throws SQLException {

		ADTK adtk = new ADTK(1, 1, 1, "sss");
		List<ADTK> adtks = new ArrayList<ADTK>();
		adtks.add(adtk);
		int insertAskDTK = askDTKDao.insertAskDTK(adtks);
		System.out.println(insertAskDTK);
	}

	@Test
	public void selectByShiJuan() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		List<ADTK> listADTKs = askDTKDao.selectADTKByShiJuan(shiJuan);
		for (ADTK adtk : listADTKs) {
			System.out.println(adtk);
		}
	}

	@Test
	public void selectByUser() throws SQLException {
		User user = new User();
		user.setId(1);
		List<ADTK> listADTKs = askDTKDao.selelctADTKByUser(user);
		for (ADTK adtk : listADTKs) {
			System.out.println(adtk);
		}
	}
}
