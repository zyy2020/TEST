package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.User;

public interface TianKongDTKDao {
	/**
	 * 
	 * 插入填空题进入答题卡
	 * 
	 * @param tkdtk
	 * @return
	 * @throws SQLException
	 */
	int insertTKDTK(List<TKDTK> tkdtks) throws SQLException;

	/**
	 * 
	 * 通过问卷查找搜有的额填空题
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(ShiJuan shiJuan,int userId) throws SQLException;

	/**
	 * 
	 * 通过提交者查找所有的填空题
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(User user) throws SQLException;
	/**
	 * 获取问卷的所有使用者
	 * @return List<Object>
	 * @throws SQLException
	 */
	List<Object>selectUserId()throws SQLException;
}
