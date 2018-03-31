package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wenjuan.dao.XuanZeDao;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.utils.JdbcUtil;

public class XuanZeTest {
	private static XuanZeDao xuanZeDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		xuanZeDao = new XuanZeDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		XuanZe xuanZe = new XuanZe();
		xuanZe.setTitle("你对待人生的态度是什么");
		int insertXuanZe = xuanZeDao.insertXuanZe(xuanZe);
		System.out.println(insertXuanZe);
	}

	@Test
	public void selectAllXuanZes() throws SQLException {
		List<XuanZe> listXuanZes = xuanZeDao.selectAllXuanZes();
		for (XuanZe xuanZe : listXuanZes) {
			System.out.println(xuanZe);
		}
	}

	@Test
	public void updateXuanZe() throws SQLException {
		XuanZe xuanZe = new XuanZe();
		xuanZe.setId(1);
		xuanZe.setTitle("你的梦想是什么");
		int insertXuanZe = xuanZeDao.updateXuanZe(xuanZe);
		System.out.println(insertXuanZe);
	}

	@Test
	public void deleteXuanZe() throws SQLException {
		int deleteXuanZeById = xuanZeDao.deleteXuanZeById(1);
		System.out.println(deleteXuanZeById);
	}
	@Test
	public void count() throws SQLException {
		long count =  xuanZeDao.selectCount();
		System.out.println(count);
	}
	@Test
	public void getScore()throws SQLException{
		List<XZDTK>xzdtks=new ArrayList<XZDTK>();
		XZDTK xzdtk=new XZDTK(1,1,1,"A");
		xzdtks.add(xzdtk);
		System.out.println(xuanZeDao.getXZScore(xzdtks));
	}
	@Test
	public void tryone()throws SQLException{
		QueryRunner qr=JdbcUtil.getQueryRunner();
		String sql="select weight1,weight2,weight3,weight4 from tb_xuanze where id=?";
		Object param=1;
		int sum=0;
		Object[] query = (Object[]) qr.query(sql, param, new ArrayHandler());
		for(Object s:query) {
			sum+=(int)s;
		}
		System.out.println(sum);
	}
}
