package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.TianKong;

public interface TianKongDao {
	/**
	 * 获取所有的填空题
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<TianKong> selectAllTianKongs() throws SQLException;

	/**
	 * 
	 * 通过id查找填空题
	 * 
	 * @return
	 * @throws SQLException
	 */
	TianKong selectTianKongById(int id) throws SQLException;

	/**
	 * 
	 * 插入填空题
	 * 
	 * @param tianKong
	 * @return
	 * @throws SQLException
	 */
	int insertTianKong(TianKong tianKong) throws SQLException;

	/**
	 * 
	 * 更新填空题
	 * 
	 * @param tianKong
	 * @return
	 * @throws SQLException
	 */
	int updateTianKong(TianKong tianKong) throws SQLException;

	/**
	 * 删除填空题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteTianKongById(int id) throws SQLException;

	/**
	 * 获取所有填空题的数目
	 * 
	 * @return
	 * @throws SQLException
	 */
	long selectCount() throws SQLException;

	/**
	 * 
	 * 获取该问卷填空题的分数
	 * 
	 * @param TianKongs
	 * @return
	 * @throws SQLException
	 */
	int getTKScore(List<TKDTK> tkdtks) throws SQLException;

	/**
	 * 获取特定页的填空题
	 * 
	 * @param pageNum
	 * @return List<TianKong>
	 * @throws SQLException
	 */
	List<TianKong> findXuanZeByPage(int pageNum) throws SQLException;
}
