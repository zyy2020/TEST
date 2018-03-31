package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Ask;

public interface AskService {
	/**
	 * 显示所有的问答题
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Ask> selectAllASKs() throws SQLException;

	/**
	 * 更新问答题
	 * 
	 * @param ask
	 * @return
	 * @throws SQLException
	 */
	boolean updateAsk(Ask ask) throws SQLException;

	/**
	 * 删除问答题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteAsk(int id) throws SQLException;

	/**
	 * 插入问答题
	 * 
	 * @param ask
	 * @return
	 * @throws SQLException
	 */
	boolean insertAsk(Ask ask) throws SQLException;
	/**
	 * 获取总共有多少页
	 * @return long
	 * @throws SQLException
	 */
	long selectAllCount()throws SQLException;
	/**
	 * 获取指定页的内容
	 * @param pageNum
	 * @return List<Ask>
	 * @throws SQLException
	 */
	List<Ask>selectAskByPageNum(int pageNum)throws SQLException;
	/**
	 * 根据id获取Ask
	 * @param id
	 * @return ask
	 * @throws SQLException
	 */
	Ask selectAskById(int id)throws SQLException;
}
