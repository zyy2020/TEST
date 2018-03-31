package com.wenjuan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.wenjuan.dao.XuanZeDTKDao;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.utils.JdbcUtil;

public class XZDTKDaoImpl implements XuanZeDTKDao {

	@Override
	public int insertXZDTK(List<XZDTK> xzdtks) throws SQLException {

		int length = xzdtks.size();
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		int i = 0;
		String sql = "insert into tb_xzdtk values(?,?,?,?)";
		Object[][] param = new Object[length][];
		for (XZDTK xzdtk : xzdtks) {
			param[i] = new Object[4];
			param[i][0] = xzdtk.getShiJuanId();
			param[i][1] = xzdtk.getXuanZeId();
			param[i][2] = xzdtk.getUserId();
			param[i][3] = xzdtk.getAnswer();
			i++;
		}
		try {
			qr.batch(sql, param);
		} catch (Exception e) {
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
	public List<XZDTK> selectXZDTKByShiJuanId(ShiJuan shiJuan,int userId) throws SQLException {
		// 为什么BeanListHandler会输出错误信息,因为类的属性要与数据库一致
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_xzdtk where shiJuanId=? and userId=?";
		Object []params = {shiJuan.getId(),userId};

		List<XZDTK> listXZDTKs = qr.query(sql, params, new BeanListHandler<XZDTK>((XZDTK.class)));

		return listXZDTKs;
	}

	@Override
	public List<XZDTK> selectXZDTKByUserId(User user) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_xzdtk where userId=?";
		Object param = user.getId();
		List<XZDTK> listXZDTKs = qr.query(sql, param, new BeanListHandler<XZDTK>((XZDTK.class)));
		return listXZDTKs;
		// DbUtils.

	}

	@Override
	public List<Object> selectUserAndId(int shiJuanId) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Object param=shiJuanId;
		String sql="select userId from tb_xzdtk where shiJuanId=? group by(userId)";
		List<Object> usersId = qr.query(sql,  new ColumnListHandler<>(1),param);
		return usersId;
	}

}
