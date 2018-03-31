package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.TianKong;

public interface TianKongService {
	/**
	 * 查看所有的填空题
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<TianKong> selectAllTianKongs() throws SQLException;

	/**
	 * 更新填空题
	 * 
	 * @param tianKong
	 * @return
	 * @throws SQLException
	 */
	boolean updateTianKong(TianKong tianKong) throws SQLException;

	/**
	 * 删除填空题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteTianKong(int id) throws SQLException;

	/**
	 * 插入填空题
	 * 
	 * @param tianKong
	 * @return
	 * @throws SQLException
	 */
	boolean insertTianKong(TianKong tianKong) throws SQLException;

	/**
	 * 得到该试卷填空题的分值
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
