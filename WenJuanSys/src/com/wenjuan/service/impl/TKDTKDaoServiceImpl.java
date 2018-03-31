package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.TianKongDTKDao;
import com.wenjuan.dao.impl.TKDTKDaoImpl;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.service.TKDTKService;

public class TKDTKDaoServiceImpl implements TKDTKService {
	private TianKongDTKDao tianKongDTKDao = new TKDTKDaoImpl();

	@Override
	public boolean insertTKDTK(List<TKDTK> tkdtks) throws SQLException {
		if (tianKongDTKDao.insertTKDTK(tkdtks) > 0)
			return true;
		return false;
	}

	@Override
	public List<TKDTK> selectTKDTK(ShiJuan shiJuan,int userId) throws SQLException {

		return tianKongDTKDao.selectTKDTK(shiJuan,userId);
	}

}
