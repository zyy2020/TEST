package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;
import com.wenjuan.bean.ShiJuan;

public interface SJAService {
	/**
	 * ��ʾָ���Ծ�������ʴ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Ask> selectAsksByShiJuan(ShiJuan shiJuan) throws SQLException;

	/**
	 * ����ָ���Ծ���ʴ���
	 * 
	 * @param sjAsk
	 * @return
	 * @throws SQLException
	 */
	boolean updateAsk(SJAsk sjAsk) throws SQLException;

	/**
	 * ɾ��ָ���Ծ���ʴ���
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteSJAsk(int shiJuanId,int askId) throws SQLException;

	/**
	 * �����ʴ������ָ�����Ծ�
	 * 
	 * @param sjAsk
	 * @return
	 * @throws SQLException
	 */
	boolean insertAsk(List<SJAsk> sjAsks) throws SQLException;
}
