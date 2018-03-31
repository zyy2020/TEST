package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;

public interface TKDTKService {
	/**
	 * 插入填空答题卡
	 * 
	 * @param tkdtks
	 * @return
	 * @throws SQLException
	 */
	boolean insertTKDTK(List<TKDTK> tkdtks) throws SQLException;

	/**
	 * 得到指定试卷的填空答题卡
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TKDTK> selectTKDTK(ShiJuan shiJuan,int userId) throws SQLException;
}
