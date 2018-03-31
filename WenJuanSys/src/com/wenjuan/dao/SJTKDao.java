package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.SJTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TianKong;

public interface SJTKDao {
	/**
	 * 插入填空题进入问卷
	 * 
	 * @param sjtk
	 * @return
	 * @throws SQLException
	 */
	int insertSJTK(List<SJTK> sjtks) throws SQLException;

	/**
	 * 通过问卷，查找填空题
	 * 
	 * @param shiJuanId
	 * @return
	 * @throws SQLException
	 */
	List<TianKong> selectByShiJuanId(ShiJuan shiJuan) throws SQLException;

	/**
	 * 更新该问卷的填空题
	 * 
	 * @return
	 * @throws SQLException
	 */
	int updateSJTK(SJTK sjtk) throws SQLException;

	/**
	 * 删除该问卷的填空题
	 * 
	 * @return
	 * @throws SQLException
	 */
	int deleteSJXZ(int shiJuanId, int tianKongId) throws SQLException;

	/**
	 * 选择所有填空题的数目
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	int selectCountTianKong(ShiJuan shiJuan) throws SQLException;
}
