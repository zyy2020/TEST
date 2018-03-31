package com.wenjuan.dao;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;

public interface SJXZDao {
	/**
	 * 插入选择题进入问卷
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	int insertSJXZ(List<SJXZ> sjxzs) throws SQLException;

	/**
	 * 通过问卷查找选择题
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<XuanZe> selectByShiJuanId(ShiJuan shiJuan) throws SQLException;

	/**
	 * 
	 * 更新问卷的选择题
	 * 
	 * @param sjxz
	 * @return
	 * @throws SQLException
	 */
	int updateByShiJuanId(SJXZ sjxz) throws SQLException;

	/**
	 * 
	 * 删除该问卷的选择题
	 * 
	 * @param ShiJuanId
	 * @param XuanZeId
	 * @return
	 * @throws SQLException
	 */
	int deleteByShiJuanId(int shiJuanId, int xuanZeId) throws SQLException;

	/**
	 * 获取该问卷选择的数量
	 * 
	 * @return
	 * @throws SQLException
	 */
	int selectCountXuanZe(ShiJuan shiJuan) throws SQLException;
}
