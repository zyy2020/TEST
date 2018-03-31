package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;

public interface XuanZeDao {
	/**
	 * 查找所有的选择题
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> selectAllXuanZes() throws SQLException;

	/**
	 * 
	 * 插入选择题
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */

	int insertXuanZe(XuanZe xuanZe) throws SQLException;

	/**
	 * 更新选择题
	 * 
	 * @param xuanZe
	 * @return
	 * @throws SQLException
	 */
	int updateXuanZe(XuanZe xuanZe) throws SQLException;

	/**
	 * 删除选题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteXuanZeById(int id) throws SQLException;

	/**
	 * 
	 * 通过id查找选择题
	 * 
	 * @return
	 * @throws SQLException
	 */
	XuanZe selectXuanZeById(int id) throws SQLException;

	/**
	 * 获取所有选题的数目
	 * 
	 * @return
	 * @throws SQLException
	 */
	long selectCount() throws SQLException;

	/**
	 * 获取该问卷的选题的分数
	 * 
	 * @param xzdtk
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
}
