package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.ShiJuanDao;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.utils.Constant;
import com.wenjuan.utils.JdbcUtil;

public class ShiJuanDaoImpl implements ShiJuanDao {

	@Override
	public List<ShiJuan> selectAllShiJuans() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_shijuan";
		List<ShiJuan> listShiJuans = (List<ShiJuan>) qr.query(sql, new BeanListHandler(ShiJuan.class));
		return listShiJuans;
	}

	@Override
	public ShiJuan selectById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_shijuan where id=?";
		Object param = id;
		ShiJuan shijuan = (ShiJuan) qr.query(sql, param, new BeanHandler(ShiJuan.class));
		return shijuan;
	}

	@Override
	public int insertShiJuan(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "insert into tb_shijuan(id,title,riqi,score) values(?,?,?,?)";
		Object params[] = {shiJuan.getId(),shiJuan.getTitle(), shiJuan.getRiqi() ,shiJuan.getScore()};
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateShiJuan(ShiJuan shiJuan) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update tb_shijuan set title=?,riqi=?,score=? where id=?";
		Object params[] = { shiJuan.getTitle(), shiJuan.getRiqi(), shiJuan.getScore(), shiJuan.getId() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int deleteShiJuanById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_shijuan where id=?";
		Object param = id;
		int update = qr.update(sql, param);
		return update;
	}

	@Override
	public ShiJuan selectShiJuanByRiQiAndName(Date riqi, String title) throws SQLException {
	    QueryRunner qr = JdbcUtil.getQueryRunner();
	    String sql="select * from tb_shiJuan where riqi=? and title=?";
	    Object []params= {riqi,title};
	    ShiJuan shiJuan = qr.query(sql, params, new BeanHandler<>(ShiJuan.class));
		return shiJuan;
	}

	@Override
	public long selectCount() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select count(id) from tb_shijuan ";
		long count = (Long) qr.query(sql, new ScalarHandler(1));
		return count;
	
	}

	@Override
	public List<ShiJuan> selectShiJuanByPageNum(int pageNum) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_shijuan limit ?,?";
		//�ӵڼ������������
		Object[] params = { (pageNum - 1) * 12, 12 };
		List<ShiJuan> listShiJuans = (List<ShiJuan>) qr.query(sql, params, new BeanListHandler(ShiJuan.class));

		return listShiJuans;
	}

}
