package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ADTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.User;

public interface AskDTKDao {
	/**
	 * 插入问答题卡
	 * 
	 * @param adtks
	 * @return
	 * @throws SQLException
	 */
	int insertAskDTK(List<ADTK> adtks) throws SQLException;

	/**
	 * 通过试卷查找该问卷的问答题
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<ADTK> selectADTKByShiJuan(ShiJuan shiJuan) throws SQLException;

	/**
	 * 通过提交者，查找问答题
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<ADTK> selelctADTKByUser(User user) throws SQLException;
	/**
	 * 获取问卷的问答题所有使用者
	 * @return
	 * @throws SQLException
	 */
	List<Object>selectUserId()throws SQLException;
}
