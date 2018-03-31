package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Mgr;

public interface MgrDao {
	/**
	 * ��ȡ���еĹ�����
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Mgr> selectAllMgrs() throws SQLException;

	/**
	 * ͨ���˺������ȡ������
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	Mgr selectMgrBynameAndPwd(String name, String pwd) throws SQLException;

	/**
	 * 
	 * ���������
	 * 
	 * @param mgr
	 * @return
	 * @throws SQLException
	 */
	int insertMgr(Mgr mgr) throws SQLException;

	/**
	 * 
	 * ���¹����ߵ���Ϣ
	 * 
	 * @param mgr
	 * @return
	 * @throws SQLException
	 */
	int updateMgr(Mgr mgr) throws SQLException;

	/**
	 * ɾ��������
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	int deleteMgrByNameAndPwd(String name, String pwd) throws SQLException;
}
