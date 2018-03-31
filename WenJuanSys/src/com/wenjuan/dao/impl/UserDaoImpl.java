package com.wenjuan.dao.impl;

import java.sql.SQLException;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.UserDao;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.utils.Constant;
import com.wenjuan.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAllUsers() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_user";
		List<User> listUsers = (List<User>) qr.query(sql, new BeanListHandler(User.class));
		return listUsers;
	}

	@Override
	public User selectUserById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_user where id=?";
		Object params[] = { id };
		User user = (User) qr.query(sql, params, new BeanHandler(User.class));
		return user;
	}

	@Override
	public User selectUserByNameAndPwd(String name, String pwd) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_user where name=? and pwd=?";
		Object params[] = { name, pwd };
		User user = (User) qr.query(sql, params, new BeanHandler(User.class));

		return user;
	}

	@Override
	public int insertUser(User user) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "insert into tb_user values(?,?,?,?,?,?)";
		Object params[] = { user.getId(), user.getName(), user.getPwd(), user.getGender(), user.getBirth(),
				user.getImg() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateUser(User user) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update tb_user set name=?,pwd=?,gender=?,birth=?,img=? where id=?";
		Object params[] = { user.getName(), user.getPwd(), user.getGender(), user.getBirth(), user.getImg(),
				user.getId() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int deleteUserById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_user where id=?";
		Object param = id;
		int update = qr.update(sql, param);
		return update;
	}

	@Override
	public int deleteUserByNameAndPwd(String name, String pwd) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_user where name=? and pwd=?";
		Object params[] = { name, pwd };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public List<User> findPageNumUser(int pageNum) throws SQLException {
	    QueryRunner qr = JdbcUtil.getQueryRunner();
	    String sql="select * from tb_user limit ?,?";
	    Object []params= {(pageNum - 1) * 6, 6};
	    List<User> listUsers = (List<User>) qr.query(sql, new BeanListHandler(User.class),params);
		return listUsers;
	}

	@Override
	public long selectCount() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select count(id) from tb_user ";
		long count = (Long) qr.query(sql, new ScalarHandler(1));
		return count;
	}

}
