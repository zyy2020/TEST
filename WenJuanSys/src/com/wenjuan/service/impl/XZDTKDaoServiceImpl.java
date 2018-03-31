package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.XuanZeDTKDao;
import com.wenjuan.dao.impl.XZDTKDaoImpl;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.service.XZDTKService;

public class XZDTKDaoServiceImpl implements XZDTKService {
	private XuanZeDTKDao xuanZeDTKDao = new XZDTKDaoImpl();

	@Override
	public boolean insertXZDTK(List<XZDTK> xzdtks) throws SQLException {
		if (xuanZeDTKDao.insertXZDTK(xzdtks) > 0)
			return true;
		return false;
	}

	@Override
	public List<XZDTK> selectXZDTK(ShiJuan shiJuan,int userId) throws SQLException {

		return xuanZeDTKDao.selectXZDTKByShiJuanId(shiJuan,userId);
	}

	@Override
	public List<Object> selectUserId(int shiJuanId) throws SQLException {
		return xuanZeDTKDao.selectUserAndId(shiJuanId);
	}

}
