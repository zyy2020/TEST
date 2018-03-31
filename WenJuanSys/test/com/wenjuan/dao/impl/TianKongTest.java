package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.TianKongDao;
import com.wenjuan.bean.TianKong;



public class TianKongTest {
	private static TianKongDao tianKongDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		tianKongDao = new TianKongDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		TianKong tianKong = new TianKong("你的名字", "周永银",2);
		int insertTianKong = tianKongDao.insertTianKong(tianKong);
		System.out.println(insertTianKong);

	}

	@Test
	public void selectAllTainKongs() throws SQLException {
		List<TianKong> listTianKongs = tianKongDao.selectAllTianKongs();
		for (TianKong tianKong : listTianKongs) {
			System.out.println(tianKong);
		}
	}

	@Test
	public void selectTianKongById() throws SQLException {
		TianKong tianKong = tianKongDao.selectTianKongById(1);
		System.out.println(tianKong);
	}

	@Test
	public void updateTianKOng() throws SQLException {
		TianKong tianKong = new TianKong( "你的名字", "诸葛亮",2);
		int updateTianKong = tianKongDao.updateTianKong(tianKong);
		System.out.println(updateTianKong);
	}

	@Test
	public void deleteTianKong() throws SQLException {
		int deleteTianKongById = tianKongDao.deleteTianKongById(1);
		System.out.println(deleteTianKongById);
	}
	@Test
	public void count() throws SQLException {
		long count = tianKongDao.selectCount();
		System.out.println(count);
	}
}
