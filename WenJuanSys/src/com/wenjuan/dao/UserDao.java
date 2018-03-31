package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.User;

public interface UserDao {
	/**
	 * 
	 * 获取所有的用户
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAllUsers() throws SQLException;

	/**
	 * 通过id查找用户
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	User selectUserById(int id) throws SQLException;

	/**
	 * 
	 * 通过密码和名字查找用户
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	User selectUserByNameAndPwd(String name, String pwd) throws SQLException;

	/**
	 * 
	 * 插入用户
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int insertUser(User user) throws SQLException;

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int updateUser(User user) throws SQLException;

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteUserById(int id) throws SQLException;

	/**
	 * 删除用户
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	int deleteUserByNameAndPwd(String name, String pwd) throws SQLException;
	/**
	 * 用户分页
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<User>findPageNumUser(int pageNum)throws SQLException;
	/**
	 * 获取所有的用户
	 * @return
	 * @throws SQLException
	 */
	long selectCount()throws SQLException;
}
