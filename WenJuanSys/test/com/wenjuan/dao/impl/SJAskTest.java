package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.SJAskDao;

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;

import com.wenjuan.bean.ShiJuan;

public class SJAskTest {
	private static SJAskDao sjAskDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		sjAskDao = new SJAskDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		Ask ask = new Ask();
		ask.setId(1);
        
		SJAsk sjAsk = new SJAsk(shiJuan, ask);
		List<SJAsk>sjAsks=new ArrayList<SJAsk>();
		sjAsks.add(sjAsk);
		int insert = sjAskDao.insertSJAsk(sjAsks);
		System.out.println(insert);
	}

	@Test
	public void select() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		List<Ask> listAsks = sjAskDao.selectAskByShiJuanId(shiJuan);
		for (Ask ask : listAsks) {
			System.out.println(ask);
		}
	}

	@Test
	public void update() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(1);
		Ask ask = new Ask();
		ask.setId(1);
		SJAsk sjAsk = new SJAsk(shiJuan, ask);
		int up = sjAskDao.updateSJAsk(sjAsk);
		System.out.println(up);
	}

	@Test
	public void delete() throws SQLException {
		int del = sjAskDao.deleteSJAsk(1, 1);
		System.out.println(del);
	}
}
