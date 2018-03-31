package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.TianKongDao;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.TianKong;
import com.wenjuan.utils.Constant;
import com.wenjuan.utils.JdbcUtil;

public class TianKongDaoImpl implements TianKongDao {

	@Override
	public List<TianKong> selectAllTianKongs() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_tiankong";
		List<TianKong> listTianKongs = (List<TianKong>) qr.query(sql, new BeanListHandler(TianKong.class));
		return listTianKongs;
	}

	@Override
	public TianKong selectTianKongById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_tiankong where id=?";
		Object param = id;
		TianKong tianKong = (TianKong) qr.query(sql, param, new BeanHandler(TianKong.class));
		return tianKong;
	}

	@Override
	public int insertTianKong(TianKong tianKong) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "insert into tb_tiankong values(?,?,?,?)";
		Object params[] = { tianKong.getId(),tianKong.getQuestion(), tianKong.getAnswer(),tianKong.getScore()};

		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateTianKong(TianKong tianKong) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update  tb_TianKong set question=?,answer=?,score=? where id=?";
		Object params[] = { tianKong.getQuestion(), tianKong.getAnswer(), tianKong.getScore(),tianKong.getId() };

		int update = qr.update(sql, params);
		return update;

	}

	@Override
	public int deleteTianKongById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete  from tb_tiankong where id=?";
		Object param = id;
		int update = qr.update(sql, param);
		return update;
	}

	@Override
	public long selectCount() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select count(id) from tb_tiankong";
		long count = (Long) qr.query(sql, new ScalarHandler());
		return count;
	}

	@Override
	public int getTKScore(List<TKDTK> tkdtks) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		int score = 0;
		
		String sql_f = "select answer from tb_tkdtk where tianKongId=?";
		String sql_t = "select * from tb_tiankong where id=?";
		Object param;
		TianKong tianKong = new TianKong();
		for (TKDTK tkdtk : tkdtks) {
			param = tkdtk.getTianKongId();
			
			String answer_f = tkdtk.getAnswer();
			
			tianKong = (TianKong) qr.query(sql_t, param, new BeanHandler<>(TianKong.class));
		
			if (answer_f.equals(tianKong.getAnswer())) {
				score += tianKong.getScore();
			}
		}
		return score;
	}

	@Override
	public List<TianKong> findXuanZeByPage(int pageNum) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		
		String sql="select * from tb_tiankong limit ?,?";
		Object []params={(pageNum-1)*Constant.PAGE_SIZE,Constant.PAGE_SIZE};
		
		return qr.query(sql, params, new BeanListHandler<>(TianKong.class) );
	}
}
