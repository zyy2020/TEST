package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Mgr;

public interface MgrDao {
	/**
	 * 获取所有的管理者
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Mgr> selectAllMgrs() throws SQLException;

	/**
	 * 通过账号密码获取管理者
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	Mgr selectMgrBynameAndPwd(String name, String pwd) throws SQLException;

	/**
	 * 
	 * 插入管理者
	 * 
	 * @param mgr
	 * @return
	 * @throws SQLException
	 */
	int insertMgr(Mgr mgr) throws SQLException;

	/**
	 * 
	 * 更新管理者的信息
	 * 
	 * @param mgr
	 * @return
	 * @throws SQLException
	 */
	int updateMgr(Mgr mgr) throws SQLException;

	/**
	 * 删除管理者
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	int deleteMgrByNameAndPwd(String name, String pwd) throws SQLException;
}
