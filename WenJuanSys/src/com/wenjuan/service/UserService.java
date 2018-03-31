package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.User;

public interface UserService {
	/**
	 * 锟介看锟斤拷锟叫碉拷锟矫伙拷
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAllUsers() throws SQLException;

	/**
	 * 锟矫伙拷锟斤拷录
	 * 
	 * @param name
	 * @param pwd
	 * @throws SQLException
	 */
	User login(String name, String pwd) throws SQLException;

	/**
	 * 锟矫伙拷注锟斤拷
	 * 
	 * @param user
	 * @throws SQLException
	 */
	boolean regist(User user) throws SQLException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	User selectById(int id)throws SQLException;
	/**
	 * 用户分页
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<User>findPageNumUser(int pageNum)throws SQLException;
	/**
	 * 获取所有的用户数量
	 * @return
	 * @throws SQLException
	 */
	long selectCount()throws SQLException;
	/**
	 * 修改用户资料
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int modifyUser(User user)throws SQLException;
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteUser(int id)throws SQLException;
}
