package com.wenjuan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.SJTKDao;
import com.wenjuan.dao.TianKongDao;
import com.wenjuan.bean.SJTK;
import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TianKong;
import com.wenjuan.utils.JdbcUtil;

public class SJTKDaoImpl implements SJTKDao {
	@Override
	public int insertSJTK(List<SJTK> sjtks) throws SQLException {
		int length = sjtks.size();
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		int i = 0;
		String sql = "insert into tb_sjtk values(?,?)";
		Object[][] param = new Object[length][];
		for (SJTK sjtk : sjtks) {
			param[i] = new Object[2];
			param[i][0] = sjtk.getShiJuan().getId();
			param[i][1] = sjtk.getTianKong().getId();
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
	public List<TianKong> selectByShiJuanId(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select tiankong_id from tb_sjtk where shijuan_id=?";
		Object param = shiJuan.getId();
		List<Integer> array = (List<Integer>) qr.query(sql, param, new ColumnListHandler("tiankong_id"));
		List<TianKong> listTKs = new ArrayList<TianKong>();
		TianKongDao tianKongDao = new TianKongDaoImpl();
		if (!array.isEmpty()) {
			for (int id : array) {
				listTKs.add(tianKongDao.selectTianKongById(id));
			}
		}
		return listTKs;
	}

	@Override
	public int updateSJTK(SJTK sjtk) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update  tb_sjtk set tiankong_id=? where shijuan_id=?";
		Object params[] = { sjtk.getTianKong().getId(), sjtk.getShiJuan().getId() };
		int update = qr.update(sql, params);
		return update;

	}

	@Override
	public int deleteSJXZ(int shiJuanId, int tianKongId) throws SQLException {

		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_sjtk where shijuan_id=? and tiankong_id=?";
		Object params[] = { shiJuanId, tianKongId };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int selectCountTianKong(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select count(tiankong_id) from tb_sjtk where shijuan_id=?";
		Object param = shiJuan.getId();
		int count = 0;
		count = (int) qr.query(sql, param, new ScalarHandler(1));
		return count;
	}

}
