package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;
import com.wenjuan.bean.ShiJuan;

public interface SJAService {
	/**
	 * 显示指定试卷的所有问答题
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Ask> selectAsksByShiJuan(ShiJuan shiJuan) throws SQLException;

	/**
	 * 更新指定试卷的问答题
	 * 
	 * @param sjAsk
	 * @return
	 * @throws SQLException
	 */
	boolean updateAsk(SJAsk sjAsk) throws SQLException;

	/**
	 * 删除指定试卷的问答题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteSJAsk(int shiJuanId,int askId) throws SQLException;

	/**
	 * 插入问答题进入指定的试卷
	 * 
	 * @param sjAsk
	 * @return
	 * @throws SQLException
	 */
	boolean insertAsk(List<SJAsk> sjAsks) throws SQLException;
}
