package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.sun.org.omg.CORBA.ExcDescriptionSeqHelper;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XZDTK;

public interface XZDTKService {
	/**
	 * 插入选择答题卡
	 * 
	 * @param xzdtks
	 * @return
	 * @throws SQLException
	 */
	boolean insertXZDTK(List<XZDTK> xzdtks) throws SQLException;

	/**
	 * 显示选择答题卡
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<XZDTK> selectXZDTK(ShiJuan shiJuan,int userId) throws SQLException;
	/**
	 * 获取所有的使用者的id
	 * @return List<Object>
	 * @throws SQLException
	 */
	List<Object>selectUserId(int shiJuanId)throws SQLException;
}
