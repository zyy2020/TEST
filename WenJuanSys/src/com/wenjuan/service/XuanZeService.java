package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;

public interface XuanZeService {
	/**
	 * ��ʾ���е�ѡ����
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> selectALLXuanZes() throws SQLException;

	/**
	 * ����ѡ����
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	boolean updateXuanZe(XuanZe xuanZe) throws SQLException;

	/**
	 * ɾ��ѡ����
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteXuanZe(int id) throws SQLException;

	/**
	 * ����ѡ����
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	boolean insertXuanZe(XuanZe xuanZe) throws SQLException;

	/**
	 * �õ����Ծ��ѡ����ķ���
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	int getXZScore(List<XZDTK> xzdtks) throws SQLException;

	/**
	 * ��ҳ����
	 * 
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> findXuanZeByPageNum(int pageNum) throws SQLException;

	/**
	 * �õ����е�ҳ��
	 * 
	 * @return
	 * @throws SQLException
	 */
	long selectAllCount() throws SQLException;

	/**
	 * ͨ��idѰ��ѡ����
	 * 
	 * @return XuanZe
	 * @throws SQLException
	 */
	XuanZe findXuanZeById(int id) throws SQLException;
}
