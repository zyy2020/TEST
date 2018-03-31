package com.wenjuan.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wenjuan.bean.ShiJuan;

public interface ShiJuanService {
	/**
	 * �����Ծ�
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	boolean insertShiJuan(ShiJuan shiJuan) throws SQLException;

	/**
	 * �鿴���е��Ծ�
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<ShiJuan> selectAllShiJuans() throws SQLException;

	/**
	 * ͨ�����ں���Ŀ�����Ծ�
	 * 
	 * @param riqi
	 * @param title
	 * @return
	 * @throws SQLException
	 */
	ShiJuan selectShiJuan(Date riqi, String title) throws SQLException;

	/**
	 * ��ȡ���е�ҳ������
	 * 
	 * @return long
	 * @throws SQLException
	 */
	long selectAllPage() throws SQLException;

	/**
	 * ��ȡĳһҳ���Ծ�
	 * 
	 * @return list<shijuan>
	 * @throws SQLException
	 */
	List<ShiJuan> selectPageNum(int pageNum) throws SQLException;
	/**
	 * ͨ��id��ȡ�Ծ�
	 * @param id 
	 * @return shiJuan
	 * @throws SQLException
	 */
	ShiJuan selectById(int id)throws SQLException;
	/**
	 * 根据id删除试卷
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteById(int id)throws SQLException;
}
