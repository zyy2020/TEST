package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.XuanZeDTKDao;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XZDTK;

public class XZDTKTest {
	private static XuanZeDTKDao xuanZeDTKDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		xuanZeDTKDao = new XZDTKDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		XZDTK xzdtk = new XZDTK(2, 1, 1, "A");
		XZDTK xzdtk2=new XZDTK(1,1,1,"B");
		List<XZDTK>xzdtks=new ArrayList<XZDTK>();
		xzdtks.add(xzdtk);
		xzdtks.add(xzdtk2);
		int insertXZDTK = xuanZeDTKDao.insertXZDTK(xzdtks);
		System.out.println(insertXZDTK);
	}

	@Test
	public void selectByShiJuan() throws SQLException {
		ShiJuan shiJuan = new ShiJuan();
		shiJuan.setId(2);
		List<XZDTK> sel = xuanZeDTKDao.selectXZDTKByShiJuanId(shiJuan,5);
		for (XZDTK xzdtk: sel) {
			System.out.println(xzdtk);
			
		}
	}

	@Test
	public void selectByUser() throws SQLException {
		User user = new User();
		user.setId(1);
		List<XZDTK> sel = xuanZeDTKDao.selectXZDTKByUserId(user);
		for (XZDTK xzdtk : sel) {
			System.out.println(xzdtk);
			
		}
	}
	@Test
	public void selectUserId()throws SQLException{
		int s=0;
		List<Object> selectUserAndId = xuanZeDTKDao.selectUserAndId(1);
		for(Object o:selectUserAndId) {
			s=(Integer)o;
			
		}
		System.out.println(s);
	}
}
