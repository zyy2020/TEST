package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;

public interface TKDTKService {
	/**
	 * ������մ��⿨
	 * 
	 * @param tkdtks
	 * @return
	 * @throws SQLException
	 */
	boolean insertTKDTK(List<TKDTK> tkdtks) throws SQLException;

	/**
	 * �õ�ָ���Ծ����մ��⿨
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(ShiJuan shiJuan,int userId) throws SQLException;
}
