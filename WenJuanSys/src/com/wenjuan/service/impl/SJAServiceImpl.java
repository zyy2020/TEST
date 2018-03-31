package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.SJAskDao;
import com.wenjuan.dao.impl.SJAskDaoImpl;
import com.wenjuan.bean.Ask;
import com.wenjuan.bean.SJAsk;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.service.SJAService;

public class SJAServiceImpl implements SJAService {
	private SJAskDao sjAskDao = new SJAskDaoImpl();

	@Override
	public List<Ask> selectAsksByShiJuan(ShiJuan shiJuan) throws SQLException {

		return sjAskDao.selectAskByShiJuanId(shiJuan);
	}

	@Override
	public boolean updateAsk(SJAsk sjAsk) throws SQLException {
		if (sjAskDao.updateSJAsk(sjAsk) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteSJAsk(int shiJuanId, int askId) throws SQLException {
		if (sjAskDao.deleteSJAsk(shiJuanId, askId) > 0)
			return true;
		return false;
	}

	@Override
	public boolean insertAsk(List<SJAsk> sjAsks) throws SQLException {
		if (sjAskDao.insertSJAsk(sjAsks) > 0)
			return true;
		return false;
	}

}
