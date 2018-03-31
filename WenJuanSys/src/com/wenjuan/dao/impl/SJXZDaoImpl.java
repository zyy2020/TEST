package com.wenjuan.dao.impl;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;


import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.SJXZDao;
import com.wenjuan.dao.XuanZeDao;
import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.utils.JdbcUtil;

public class SJXZDaoImpl implements SJXZDao {

	@Override
	public int insertSJXZ(List<SJXZ> sjxzs) throws SQLException {
		int length=sjxzs.size();
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		int i=0;
		String sql = "insert into tb_sjxz values(?,?)";
		Object [][]param=new Object[length][];
		for(SJXZ sjxz:sjxzs) {
			param[i]=new Object[2];
			param[i][0]=sjxz.getShiJuan().getId();
			param[i][1]=sjxz.getXuanZe().getId();
			i++;
		}
		try {
			qr.batch(sql, param);
		}catch (Exception e) {
			conn.rollback();
		   System.out.println(e.getMessage());
		   return 0;
		}
		conn.commit();
		conn.setAutoCommit(true);
		JdbcUtil.releaseDB(conn);
		return 1;
	}

	@Override
	public List<XuanZe> selectByShiJuanId(ShiJuan shiJuan) throws SQLException {
		XuanZeDao xuanZeDao = new XuanZeDaoImpl();
		QueryRunner qr = JdbcUtil.getQueryRunner();

		String sql = "select xuanze_id from tb_sjxz where shijuan_id=?";
		Object param = shiJuan.getId();
		// 得到选择题的id
		List<Integer> array = (List<Integer>) qr.query(sql, param, new ColumnListHandler("xuanze_id"));

		// 根据id找到选择题
		List<XuanZe> listXuans = new ArrayList<XuanZe>();
		if (!array.isEmpty()) {
			for (int id : array) {
				listXuans.add(xuanZeDao.selectXuanZeById(id));
			}
		}
		return listXuans;
	}

	@Override
	public int updateByShiJuanId(SJXZ sjxz) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update  tb_sjxz set xuanze_id=? where shijuan_id=?";
		Object params[] = { sjxz.getXuanZe().getId(), sjxz.getShiJuan().getId() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int deleteByShiJuanId(int shiJuanId, int xuanZeId) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_sjxz where shijuan_id=? and xuanze_id=?";
		Object params[] = { shiJuanId, xuanZeId };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int selectCountXuanZe(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr=JdbcUtil.getQueryRunner();
		String sql="select count(xuanze_id) from tb_sjxz where shijuan_id=?";
		Object param=shiJuan.getId();
		int count=0;
	    count=(int) qr.query(sql, param, new ScalarHandler(1));
		return count;
	}

}
