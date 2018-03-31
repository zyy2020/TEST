package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Ask;

public interface AskDao {
	/**
	 * 获取所有的问答题
	 * 
	 * @return List<Ask>
	 * @throws SQLException
	 */
	List<Ask> selectAllAsks() throws SQLException;

	/**
	 * 通过Id获取问答题
	 * 
	 * @param id
	 * @return Ask
	 * @throws SQLException
	 */
	Ask selectAskById(int id) throws SQLException;
    /**
     * 插入问答题
     * @param ask
     * @return
     * @throws SQLException
     */
	
	int insertAsk(Ask ask) throws SQLException;

	/**
	 * 更新问答题
	 * 
	 * @param ask
	 * @return 
	 * @throws SQLException
	 */
	int updateAsk(Ask ask) throws SQLException;

	/**
	 * 删除问答题
	 * 
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
	int deleteAsk(int id) throws SQLException;

	/**
	 * 
	 * 获取所有问答题的数目
	 * @return long
	 * @throws SQLException
	 */
	long selectCount() throws SQLException;
	/**
	 * 获取特定页的问答题的数据
	 * @param pageNum
	 * @return List<Ask>
	 * @throws SQLException
	 */
	List<Ask>selectAskByPageNum(int pageNum)throws SQLException;
}
