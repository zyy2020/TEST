package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.TianKongDao;
import com.wenjuan.dao.impl.TianKongDaoImpl;
import com.wenjuan.bean.TKDTK;
import com.wenjuan.bean.TianKong;
import com.wenjuan.service.TianKongService;
import com.wenjuan.utils.Constant;

public class TianKongServiceImpl implements TianKongService {
	private TianKongDao tianKongDao = new TianKongDaoImpl();

	@Override
	public List<TianKong> selectAllTianKongs() throws SQLException {

		return tianKongDao.selectAllTianKongs();
	}

	@Override
	public boolean updateTianKong(TianKong tianKong) throws SQLException {
		if (tianKongDao.updateTianKong(tianKong) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteTianKong(int id) throws SQLException {
		if (tianKongDao.deleteTianKongById(id) > 0)
			return true;
		return false;
	}

	@Override
	public boolean insertTianKong(TianKong tianKong) throws SQLException {
		if (tianKongDao.insertTianKong(tianKong) > 0)
			return true;
		return false;
	}

	@Override
	public int getTKScore(List<TKDTK> tkdtks) throws SQLException {

		return tianKongDao.getTKScore(tkdtks);
	}

	@Override
	public long findAllCount() throws SQLException {
		
		return tianKongDao.selectCount()%Constant.PAGE_SIZE==0?tianKongDao.selectCount()/Constant.PAGE_SIZE:tianKongDao.selectCount()/Constant.PAGE_SIZE+1;
	}

	@Override
	public List<TianKong> findTianKongByPage(int pageNum) throws SQLException {
		
		return tianKongDao.findXuanZeByPage(pageNum);
	}

	@Override
	public TianKong selectTianKongById(int id) throws SQLException {
		
		return tianKongDao.selectTianKongById(id);
	}

}
