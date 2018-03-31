package com.wenjuan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.AskDao;
import com.wenjuan.dao.SJAskDao;

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;
import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;

import com.wenjuan.utils.JdbcUtil;

public class SJAskDaoImpl implements SJAskDao {

	@Override
	public int insertSJAsk(List<SJAsk> sjasks) throws SQLException {
		int length=sjasks.size();
		QueryRunner qr = JdbcUtil.getQueryRunner();
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		int i=0;
		String sql = "insert into tb_sjask values(?,?)";
		Object [][]param=new Object[length][];
		for(SJAsk sjask:sjasks) {
			param[i]=new Object[2];
			param[i][0]=sjask.getShiJuan().getId();
			param[i][1]=sjask.getAsk().getId();
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
	public List<Ask> selectAskByShiJuanId(ShiJuan shiJuan) throws SQLException {

		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select ask_id from tb_sjask where shijuan_id=?";
		Object param = shiJuan.getId();
		List<Integer> array = (List<Integer>) qr.query(sql, param, new ColumnListHandler("ask_id"));
		List<Ask> listAsks = new ArrayList<Ask>();
		AskDao askDao = new AskDaoImpl();
		if (!array.isEmpty()) {
			for (int id : array) {
				listAsks.add(askDao.selectAskById(id));
			}
		}
		return listAsks;

	}

	@Override
	public int deleteSJAsk(int shiJuanId, int askId) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_sjask where shijuan_id=? and ask_id=?";
		Object params[] = { shiJuanId, askId };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateSJAsk(SJAsk sjAsk) throws SQLException {

		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update  tb_sjask set ask_id=? where shijuan_id=?";
		Object params[] = { sjAsk.getAsk().getId(), sjAsk.getShiJuan().getId() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int selectCountAsk(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr=JdbcUtil.getQueryRunner();
		String sql="select count(ask_id) from tb_sjask where shijuan_id=?";
		Object param=shiJuan.getId();
		int count=0;
	    count=(int) qr.query(sql, param, new ScalarHandler(1));
		return count;
	}

}
