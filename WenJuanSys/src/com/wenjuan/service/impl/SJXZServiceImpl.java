package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.SJXZDao;
import com.wenjuan.dao.impl.SJXZDaoImpl;
import com.wenjuan.bean.SJXZ;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.service.SJXZService;

public class SJXZServiceImpl implements SJXZService {
    private SJXZDao sjxzDao=new SJXZDaoImpl();
	@Override
	public List<XuanZe> selectSJXZs(ShiJuan shiJuan) throws SQLException {
		
		return sjxzDao.selectByShiJuanId(shiJuan);
	}

	@Override
	public boolean updateSJXZ(SJXZ sjxz) throws SQLException {
		if(sjxzDao.updateByShiJuanId(sjxz)>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteSJXZ(int shiJuanId, int xuanZeId) throws SQLException {
		if(sjxzDao.deleteByShiJuanId(shiJuanId, xuanZeId)>0)
			return true;
		return false;
	}

	@Override
	public boolean insertSJXZ(List<SJXZ >sjxzs) throws SQLException {
		if(sjxzDao.insertSJXZ(sjxzs)>0)
			return true;
		return false;
	}

}
