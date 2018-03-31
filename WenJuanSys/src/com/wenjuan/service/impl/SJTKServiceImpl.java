package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.SJTKDao;
import com.wenjuan.dao.impl.SJTKDaoImpl;
import com.wenjuan.bean.SJTK;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.TianKong;
import com.wenjuan.service.SJTKService;

public class SJTKServiceImpl implements SJTKService {
    private SJTKDao sjtkDao=new SJTKDaoImpl();
	@Override
	public List<TianKong> selectSJTKs(ShiJuan shiJuan) throws SQLException {
	
		return sjtkDao.selectByShiJuanId(shiJuan);
	}

	@Override
	public boolean updateSJTK(SJTK sjtk) throws SQLException {
		if(sjtkDao.updateSJTK(sjtk)>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteSJTK(int shiJuanId,int tianKongId) throws SQLException {
		if(sjtkDao.deleteSJXZ(shiJuanId, tianKongId)>0)
			return true;
		return false;
	}

	@Override
	public boolean insertSJTK(List<SJTK> sjtks) throws SQLException {
		if(sjtkDao.insertSJTK(sjtks)>0)
			return true;
		return false;
	}

}
