package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.AskDao;
import com.wenjuan.bean.Ask;

public class AskTest {
	private static AskDao askDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		askDao = new AskDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		Ask ask = new Ask("你最向往的生活");
		int insertAsk = askDao.insertAsk(ask);
		System.out.println(insertAsk);
	}

	@Test
	public void selelctAllAsks() throws SQLException {
		List<Ask> listAsks = askDao.selectAllAsks();
		for (Ask ask : listAsks) {
			System.out.println(ask);
		}
	}

	@Test
	public void selectAskById() throws SQLException {
		Ask ask = askDao.selectAskById(1);
		System.out.println(ask);
	}

	@Test
	public void updateAsk() throws SQLException {
		Ask ask = new Ask(1, "你心目中的女神是什么样的");
		int updateAsk = askDao.updateAsk(ask);
		System.out.println(updateAsk);
	}

	@Test
	public void deleteAsk() throws SQLException {
		int deleteAsk = askDao.deleteAsk(1);
		System.out.println(deleteAsk);
	}
	@Test
	public void count() throws SQLException {
		long count = askDao.selectCount();
		System.out.println(count);
	}
}
