package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wenjuan.dao.MgrDao;
import com.wenjuan.bean.Mgr;
import com.wenjuan.utils.JdbcUtil;

public class MgrDaoImpl implements MgrDao {

	@Override
	public List<Mgr> selectAllMgrs() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_mgr";
		List<Mgr> listMgrs = (List<Mgr>) qr.query(sql, new BeanListHandler(Mgr.class));
		return listMgrs;
	}

	@Override
	public Mgr selectMgrBynameAndPwd(String name, String pwd) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_mgr where name=? and pwd=?";
		Object params[] = { name, pwd };
		Mgr mgr = (Mgr) qr.query(sql, params, new BeanHandler(Mgr.class));
		return mgr;
	}

	@Override
	public int insertMgr(Mgr mgr) throws SQLException {
		//从页面获取之后，再加密
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "insert into tb_mgr values(?,?,?)";
		Object params[] = { mgr.getId(), mgr.getName(), mgr.getPwd() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateMgr(Mgr mgr) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update tb_mgr set name=?,pwd=?  where id=?";
		Object params[] = { mgr.getName(), mgr.getPwd(), mgr.getId() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int deleteMgrByNameAndPwd(String name, String pwd) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_mgr where name=? and pwd=?";
		Object params[] = { name, pwd };
		int update = qr.update(sql, params);
		return update;
	}

}
