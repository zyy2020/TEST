package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.ShiJuanDao;
import com.wenjuan.bean.ShiJuan;

public class ShiJuanTest {
	private static ShiJuanDao shiJuanDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		shiJuanDao = new ShiJuanDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 6, 6);
		Date date = calendar.getTime();
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setRiqi(date);
		shiJuan.setTitle("广西师范大学问卷");
		int insertShiJuan = shiJuanDao.insertShiJuan(shiJuan);
		System.out.println(insertShiJuan);
	}

	@Test
	public void selectAllShiJuans() throws SQLException {
		List<ShiJuan> listShiJuan = shiJuanDao.selectAllShiJuans();
		for (ShiJuan shiJuan : listShiJuan) {
			System.out.println(shiJuan);
		}
	}

	@Test
	public void selectShiJuanById() throws SQLException {
		ShiJuan shiJuan = shiJuanDao.selectById(1);
		System.out.println(shiJuan);
	}

	@Test
	public void updateShiJuan() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setTitle("广西师范大学调查问卷");
		shiJuan.setRiqi(new Date());
		shiJuan.setId(1);
		int updateShiJuan = shiJuanDao.updateShiJuan(shiJuan);
		System.out.println(updateShiJuan);
	}

	@Test
	public void deleteShiJuan() throws SQLException {
		int deleteShiJuanById = shiJuanDao.deleteShiJuanById(1);
		System.out.println(deleteShiJuanById);
	}
}
