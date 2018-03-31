package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ADTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.dao.AskDTKDao;
import com.wenjuan.dao.impl.ADTKDaoImpl;
import com.wenjuan.service.ADTKService;

public class ADTKServiceImpl implements ADTKService {
	private AskDTKDao askDTKDao = new ADTKDaoImpl();

	@Override
	public boolean insertADTK(List<ADTK> adtks) throws SQLException {
		if (askDTKDao.insertAskDTK(adtks) > 0)
			return true;
		return false;
	}

	@Override
	public List<ADTK> selectSJDTK(ShiJuan shiJuan) throws SQLException {

		return askDTKDao.selectADTKByShiJuan(shiJuan);
	}

}
