package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wenjuan.bean.ShiJuan;

public interface ShiJuanDao {
	/**
	 * 
	 * 获取所有的试卷
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<ShiJuan> selectAllShiJuans() throws SQLException;

	/**
	 * 通过问卷id获取问卷
	 * 
	 * @return
	 * @throws SQLException
	 */
	ShiJuan selectById(int id) throws SQLException;

	/**
	 * 
	 * 插入问卷
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	int insertShiJuan(ShiJuan shiJuan) throws SQLException;

	/**
	 * 更新问卷
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	int updateShiJuan(ShiJuan shiJuan) throws SQLException;

	/**
	 * 删除问卷
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteShiJuanById(int id) throws SQLException;

	/**
	 * 通过日期和title查找问卷
	 * 
	 * @param date
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	ShiJuan selectShiJuanByRiQiAndName(Date riqi, String title) throws SQLException;

	/**
	 * 获取所有的问卷数量
	 * 
	 * @return long
	 * @throws SQLException
	 */
	long selectCount() throws SQLException;

	/**
	 * 获取当前页的问卷
	 * 
	 * @param pageNum
	 * @return List<ShiJuan>
	 * @throws SQLException
	 */
	List<ShiJuan> selectShiJuanByPageNum(int pageNum) throws SQLException;
}
