package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.TianKong;

public interface TianKongService {
	/**
	 * �鿴���е������
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<TianKong> selectAllTianKongs() throws SQLException;

	/**
	 * ���������
	 * 
	 * @param tianKong
	 * @return
	 * @throws SQLException
	 */
	boolean updateTianKong(TianKong tianKong) throws SQLException;

	/**
	 * ɾ�������
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteTianKong(int id) throws SQLException;

	/**
	 * ���������
	 * 
	 * @param tianKong
	 * @return
	 * @throws SQLException
	 */
	boolean insertTianKong(TianKong tianKong) throws SQLException;

	/**
	 * �õ����Ծ������ķ�ֵ
	 * 
	 * @param tkdtks
	 * @return
	 * @throws SQLException
	 */
	int getTKScore(List<TKDTK> tkdtks) throws SQLException;
	/**
	 * 
	 * @return long
	 * @throws SQLException
	 */
	long findAllCount()throws SQLException;
	/**
	 * 
	 * @param pageNum
	 * @return List<TianKong>
	 * @throws SQLException
	 */
	List<TianKong> findTianKongByPage(int pageNum)throws SQLException;
	/**
	 * 
	 * @param id
	 * @return  TianKong
	 * @throws SQLException
	 */
	TianKong selectTianKongById(int id)throws SQLException;
}
