package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;

public interface SJXZService {
	/**
	 * 选择指定试卷的的所有选择题
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> selectSJXZs(ShiJuan shiJuan) throws SQLException;

	/**
	 * 更新指定试卷的选择题
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	boolean updateSJXZ(SJXZ sjxz) throws SQLException;

	/**
	 * 删除指定试卷的选择题
	 * 
	 * @param ShiJuanId
	 * @param XuanZeId
	 * @return
	 * @throws SQLException
	 */
	boolean deleteSJXZ(int shiJuanId, int xuanZeId) throws SQLException;

	/**
	 * 插入指定的选择题进试卷
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	boolean insertSJXZ(List<SJXZ> sjxzs) throws SQLException;
}
