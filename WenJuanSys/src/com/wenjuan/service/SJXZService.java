package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;

public interface SJXZService {
	/**
	 * ѡ��ָ���Ծ�ĵ�����ѡ����
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> selectSJXZs(ShiJuan shiJuan) throws SQLException;

	/**
	 * ����ָ���Ծ��ѡ����
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	boolean updateSJXZ(SJXZ sjxz) throws SQLException;

	/**
	 * ɾ��ָ���Ծ��ѡ����
	 * 
	 * @param ShiJuanId
	 * @param XuanZeId
	 * @return
	 * @throws SQLException
	 */
	boolean deleteSJXZ(int shiJuanId, int xuanZeId) throws SQLException;

	/**
	 * ����ָ����ѡ������Ծ�
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	boolean insertSJXZ(List<SJXZ> sjxzs) throws SQLException;
}
