package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;

public interface TianKngDTKDao {
	/**
	 * ������մ��⿨
	 * 
	 * @param tkdtk
	 * @return
	 * @throws SQLException
	 */
	int insertTKDTK(TKDTK tkdtk) throws SQLException;

	/**
	 * ͨ���Ծ�idѡ����⿨
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(ShiJuan shiJuan) throws SQLException;

	/**
	 * ͨ��������ѡ����⿨
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(User user) throws SQLException;
	/**
	 * ��ȡ���⿨�е����д�����
	 * @return List<Object>
	 * @throws SQLException
	 */
	List<Object>selectUserId()throws SQLException;
}
