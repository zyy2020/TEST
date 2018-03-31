package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;

public interface TianKngDTKDao {
	/**
	 * 插入填空答题卡
	 * 
	 * @param tkdtk
	 * @return
	 * @throws SQLException
	 */
	int insertTKDTK(TKDTK tkdtk) throws SQLException;

	/**
	 * 通过试卷id选择答题卡
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(ShiJuan shiJuan) throws SQLException;

	/**
	 * 通过答题者选择答题卡
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(User user) throws SQLException;
	/**
	 * 获取答题卡中的所有答题者
	 * @return List<Object>
	 * @throws SQLException
	 */
	List<Object>selectUserId()throws SQLException;
}
