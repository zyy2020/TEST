package com.wenjuan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.wenjuan.bean.ADTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;
import com.wenjuan.dao.AskDTKDao;
import com.wenjuan.utils.JdbcUtil;

public class ADTKDaoImpl implements AskDTKDao {

	@Override
	public int insertAskDTK(List<ADTK> adtks) throws SQLException {
		int length = adtks.size();
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		int i = 0;
		String sql = "insert into tb_adtk values(?,?,?,?)";
		Object[][] param = new Object[length][];
		for (ADTK adtk : adtks) {
			param[i] = new Object[4];
			param[i][0] = adtk.getShiJuanId();
			param[i][1] = adtk.getAskId();
			param[i][2] = adtk.getUserId();
			param[i][3] = adtk.getAnswer();
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
	public List<ADTK> selectADTKByShiJuan(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_adtk where shiJuanId=?";
		Object param = shiJuan.getId();
		List<ADTK> listADTKs = qr.query(sql, param, new BeanListHandler<ADTK>(ADTK.class));
		return listADTKs;
	}

	@Override
	public List<ADTK> selelctADTKByUser(User user) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_adtk where userId=?";
		Object param = user.getId();
		List<ADTK> listADTKs = qr.query(sql, param, new BeanListHandler<ADTK>(ADTK.class));
		return listADTKs;
	}

	@Override
	public List<Object> selectUserId() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql="select userId from tb_adtk group by(userId)";
		List<Object> usersId = qr.query(sql,new ColumnListHandler<>(1));
		return usersId;
	}

}
