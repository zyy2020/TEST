package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.SJTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TianKong;

public interface SJTKService {
	/**
	 * ѡ��ָ���Ծ�����������
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TianKong> selectSJTKs(ShiJuan shiJuan) throws SQLException;

	/**
	 * ����ָ���Ծ�������
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	boolean updateSJTK(SJTK sjtk) throws SQLException;

	/**
	 * ɾ��ָ���Ծ�������
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteSJTK(int shiJuanId,int tianKongId) throws SQLException;

	/**
	 * ������������ָ�����Ծ�
	 * 
	 * @param sjtk
	 * @return
	 * @throws SQLException
	 */
	boolean insertSJTK(List<SJTK> sjtks) throws SQLException;
}
