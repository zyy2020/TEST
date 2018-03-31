package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.AskDao;
import com.wenjuan.dao.impl.AskDaoImpl;
import com.wenjuan.bean.Ask;
import com.wenjuan.service.AskService;
import com.wenjuan.utils.Constant;

public class AskServiceImpl implements AskService {
	private AskDao askDao = new AskDaoImpl();

	@Override
	public List<Ask> selectAllASKs() throws SQLException {

		return askDao.selectAllAsks();
	}

	@Override
	public boolean updateAsk(Ask ask) throws SQLException {
		if (askDao.updateAsk(ask) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteAsk(int id) throws SQLException {
		if (askDao.deleteAsk(id) > 0)
			return true;
		return false;
	}

	@Override
	public boolean insertAsk(Ask ask) throws SQLException {
		if (askDao.insertAsk(ask) > 0)
			return true;
		return false;
	}

	@Override
	public long selectAllCount() throws SQLException {
		
		return askDao.selectCount()%Constant.PAGE_SIZE==0?askDao.selectCount()/Constant.PAGE_SIZE:askDao.selectCount()/Constant.PAGE_SIZE+1;
	}

	@Override
	public List<Ask> selectAskByPageNum(int pageNum) throws SQLException {
		
		return askDao.selectAskByPageNum(pageNum);
	}

	@Override
	public Ask selectAskById(int id) throws SQLException {
		
		return askDao.selectAskById(id);
	}

}
