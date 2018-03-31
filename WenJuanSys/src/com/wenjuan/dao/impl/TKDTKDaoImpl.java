package com.wenjuan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.wenjuan.dao.TianKongDTKDao;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.utils.JdbcUtil;

public class TKDTKDaoImpl implements TianKongDTKDao {

	@Override
	public int insertTKDTK(List<TKDTK> tkdtks) throws SQLException {
		int length = tkdtks.size();
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		int i = 0;
		String sql = "insert into tb_tkdtk values(?,?,?,?)";
		Object[][] param = new Object[length][];
		for (TKDTK tkdtk : tkdtks) {
			param[i] = new Object[4];
			param[i][0] = tkdtk.getShiJuanId();
			param[i][1] = tkdtk.getTianKongId();
			param[i][2] = tkdtk.getUserId();
			param[i][3] = tkdtk.getAnswer();
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
	public List<TKDTK> selectTKDTK(ShiJuan shiJuan,int userId) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_tkdtk where shiJuanId=? and userId=?";
		Object []params = {shiJuan.getId(),userId};
		List<TKDTK> listTKDTKs = qr.query(sql, params, new BeanListHandler<TKDTK>(TKDTK.class));
		return listTKDTKs;
	}

	@Override
	public List<TKDTK> selectTKDTK(User user) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_tkdtk where userId=?";
		Object param = user.getId();
		List<TKDTK> listTKDTKs = qr.query(sql, param, new BeanListHandler<TKDTK>(TKDTK.class));
		return listTKDTKs;
	}

	@Override
	public List<Object> selectUserId() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql="select userId from tb_tkdtk group by(userId)";
		List<Object> usersId = qr.query(sql,new ColumnListHandler<>(1));
		return usersId;
	}

}
