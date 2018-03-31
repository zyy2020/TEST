package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.SJTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TianKong;

public interface SJTKService {
	/**
	 * 选择指定试卷的所有填空题
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<TianKong> selectSJTKs(ShiJuan shiJuan) throws SQLException;

	/**
	 * 更新指定试卷的填空题
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	boolean updateSJTK(SJTK sjtk) throws SQLException;

	/**
	 * 删除指定试卷的填空题
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	boolean deleteSJTK(int shiJuanId,int tianKongId) throws SQLException;

	/**
	 * 插入填空题进入指定的试卷
	 * 
	 * @param sjtk
	 * @return
	 * @throws SQLException
	 */
	boolean insertSJTK(List<SJTK> sjtks) throws SQLException;
}
