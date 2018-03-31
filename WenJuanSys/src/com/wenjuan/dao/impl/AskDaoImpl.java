package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.AskDao;
import com.wenjuan.bean.Ask;
import com.wenjuan.utils.Constant;
import com.wenjuan.utils.JdbcUtil;

public class AskDaoImpl implements AskDao {

	@Override
	public List<Ask> selectAllAsks() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_ask";
		List<Ask> listAsks = (List<Ask>) qr.query(sql, new BeanListHandler(Ask.class));

		return listAsks;
	}

	@Override
	public Ask selectAskById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_ask where id=?";
		Object param = id;
		Ask ask = qr.query(sql, new BeanHandler<Ask>(Ask.class),param);

		return ask;
	}

	@Override
	public int insertAsk(Ask ask) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "insert into tb_ask values(?,?)";
		Object params[] = { ask.getId(), ask.getQuestion() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateAsk(Ask ask) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update tb_ask set question=? where id=?";
		Object params[] = { ask.getQuestion(), ask.getId() };
		int update = qr.update(sql, params);
		return update;

	}

	@Override
	public int deleteAsk(int id) throws SQLException {

		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_ask where id=?";
		Object param = id;
		int update = qr.update(sql, param);
		return update;
	}

	@Override
	public long selectCount() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql="select count(id) from tb_ask";
		long count = (Long) qr.query(sql, new ScalarHandler(1));
		return count;
	}

	@Override
	public List<Ask> selectAskByPageNum(int pageNum) throws SQLException {
	    QueryRunner qr = JdbcUtil.getQueryRunner();
	    String sql="select * from tb_ask limit ?,?";
	    Object []params= {(pageNum-1)*Constant.PAGE_SIZE,Constant.PAGE_SIZE};
	    
		return (List<Ask>) qr.query(sql, params, new BeanListHandler(Ask.class));
	}

}
