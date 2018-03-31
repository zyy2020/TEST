package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;
import com.wenjuan.bean.ShiJuan;

public interface SJAskDao {
	/**
	 * 
	 * 插入问答题进入问卷
	 * 
	 * @param sjAsk
	 * @return
	 * @throws SQLException
	 */
	int insertSJAsk(List<SJAsk> sjAsks) throws SQLException;

	/**
	 * 通过问卷获取问答题
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<Ask> selectAskByShiJuanId(ShiJuan shiJuan) throws SQLException;

	/**
	 * 更新该问卷的问答题
	 * 
	 * @param sjAsk
	 * @return
	 * @throws SQLException
	 */
	int updateSJAsk(SJAsk sjAsk) throws SQLException;

	/**
	 * 删除该问卷的问答题
	 * 
	 * @param shiJuanId
	 * @return
	 * @throws SQLException
	 */
	int deleteSJAsk(int shiJuanId, int askId) throws SQLException;

	/**
	 * 获取所有问答题的数目
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	int selectCountAsk(ShiJuan shiJuan) throws SQLException;
}
