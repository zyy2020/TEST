package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;

public interface XuanZeService {
	/**
	 * 显示所有的选择题
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> selectALLXuanZes() throws SQLException;

	/**
	 * 更新选择题
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	boolean updateXuanZe(XuanZe xuanZe) throws SQLException;

	/**
	 * 删除选择题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteXuanZe(int id) throws SQLException;

	/**
	 * 插入选择题
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	boolean insertXuanZe(XuanZe xuanZe) throws SQLException;

	/**
	 * 得到该试卷的选择题的分数
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	int getXZScore(List<XZDTK> xzdtks) throws SQLException;

	/**
	 * 分页函数
	 * 
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> findXuanZeByPageNum(int pageNum) throws SQLException;

	/**
	 * 得到所有的页数
	 * 
	 * @return
	 * @throws SQLException
	 */
	long selectAllCount() throws SQLException;

	/**
	 * 通过id寻找选择题
	 * 
	 * @return XuanZe
	 * @throws SQLException
	 */
	XuanZe findXuanZeById(int id) throws SQLException;
}
