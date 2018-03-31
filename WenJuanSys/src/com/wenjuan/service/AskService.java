package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Ask;

public interface AskService {
	/**
	 * ��ʾ���е��ʴ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Ask> selectAllASKs() throws SQLException;

	/**
	 * �����ʴ���
	 * 
	 * @param ask
	 * @return
	 * @throws SQLException
	 */
	boolean updateAsk(Ask ask) throws SQLException;

	/**
	 * ɾ���ʴ���
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteAsk(int id) throws SQLException;

	/**
	 * �����ʴ���
	 * 
	 * @param ask
	 * @return
	 * @throws SQLException
	 */
	boolean insertAsk(Ask ask) throws SQLException;
	/**
	 * ��ȡ�ܹ��ж���ҳ
	 * @return long
	 * @throws SQLException
	 */
	long selectAllCount()throws SQLException;
	/**
	 * ��ȡָ��ҳ������
	 * @param pageNum
	 * @return List<Ask>
	 * @throws SQLException
	 */
	List<Ask>selectAskByPageNum(int pageNum)throws SQLException;
	/**
	 * ����id��ȡAsk
	 * @param id
	 * @return ask
	 * @throws SQLException
	 */
	Ask selectAskById(int id)throws SQLException;
}
