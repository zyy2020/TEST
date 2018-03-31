package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.User;

public interface UserService {
	/**
	 * �鿴���е��û�
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAllUsers() throws SQLException;

	/**
	 * �û���¼
	 * 
	 * @param name
	 * @param pwd
	 * @throws SQLException
	 */
	User login(String name, String pwd) throws SQLException;

	/**
	 * �û�ע��
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
	 * �û���ҳ
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<User>findPageNumUser(int pageNum)throws SQLException;
	/**
	 * ��ȡ���е��û�����
	 * @return
	 * @throws SQLException
	 */
	long selectCount()throws SQLException;
	/**
	 * �޸��û�����
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int modifyUser(User user)throws SQLException;
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteUser(int id)throws SQLException;
}
