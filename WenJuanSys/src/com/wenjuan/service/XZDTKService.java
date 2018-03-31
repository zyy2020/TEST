package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.sun.org.omg.CORBA.ExcDescriptionSeqHelper;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XZDTK;

public interface XZDTKService {
	/**
	 * ����ѡ����⿨
	 * 
	 * @param xzdtks
	 * @return
	 * @throws SQLException
	 */
	boolean insertXZDTK(List<XZDTK> xzdtks) throws SQLException;

	/**
	 * ��ʾѡ����⿨
	 * 
	 * @param shiJuan
	 * @return
	 * @throws SQLException
	 */
	List<XZDTK> selectXZDTK(ShiJuan shiJuan,int userId) throws SQLException;
	/**
	 * ��ȡ���е�ʹ���ߵ�id
	 * @return List<Object>
	 * @throws SQLException
	 */
	List<Object>selectUserId(int shiJuanId)throws SQLException;
}
