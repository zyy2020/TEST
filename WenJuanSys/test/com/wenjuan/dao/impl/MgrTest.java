package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.MgrDao;
import com.wenjuan.bean.Mgr;

public class MgrTest {
	private static MgrDao mgrDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		mgrDao = new MgrDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		Mgr mgr = new Mgr("李四", "123456");
		int insertMgr = mgrDao.insertMgr(mgr);
		System.out.println(insertMgr);
	}

	@Test
	public void selectAllMgrs() throws SQLException {
		List<Mgr> listMgrs = mgrDao.selectAllMgrs();
		for (Mgr mgr : listMgrs) {
			System.out.println(mgr);
		}
	}

	@Test
	public void selectMgr() throws SQLException {
		Mgr mgr = mgrDao.selectMgrBynameAndPwd("李四", "123456");
		System.out.println(mgr);
	}

	@Test
	public void updateMgr() throws SQLException {
		Mgr mgr = new Mgr(1, "赵云", "456789");
		int updateMgr = mgrDao.updateMgr(mgr);
		System.out.println(updateMgr);
	}

	@Test
	public void deleteMgr() throws SQLException {
		int deleteMgrByNameAndPwd = mgrDao.deleteMgrByNameAndPwd("赵云", "456789");
		System.out.println(deleteMgrByNameAndPwd);
	}
}
