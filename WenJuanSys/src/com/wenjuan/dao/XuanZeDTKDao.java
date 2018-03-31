package com.wenjuan.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.User;
import com.wenjuan.bean.XZDTK;

public interface XuanZeDTKDao {
	/**
	 * 
	 * 插入选择题进入问卷
	 * 
	 * @param xzdtk
	 * @return
	 * @throws SQLException
	 */
	int insertXZDTK(List<XZDTK> xzdtks) throws SQLException;

	/**
	 * 
	 * 选择所有的选题通过问卷
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<XZDTK> selectXZDTKByShiJuanId(ShiJuan shiJuan,int userId) throws SQLException;

	/**
	 * 
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<XZDTK> selectXZDTKByUserId(User user) throws SQLException;
	/**
	 * 获取User
	 * @return List<User>
	 * @throws SQLException
	 */
    List<Object>selectUserAndId(int shiJuanId)throws SQLException;

}
