package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.XuanZeDao;
import com.wenjuan.dao.impl.XuanZeDaoImpl;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.service.XuanZeService;
import com.wenjuan.utils.Constant;

public class XuanZeServiceImpl implements XuanZeService {
	private XuanZeDao xuanZeDao = new XuanZeDaoImpl();

	@Override
	public List<XuanZe> selectALLXuanZes() throws SQLException {

		return xuanZeDao.selectAllXuanZes();
	}

	@Override
	public boolean updateXuanZe(XuanZe xuanZe) throws SQLException {
		if (xuanZeDao.updateXuanZe(xuanZe) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteXuanZe(int id) throws SQLException {
		if (xuanZeDao.deleteXuanZeById(id) > 0)
			return true;
		return false;
	}

	@Override
	public boolean insertXuanZe(XuanZe xuanZe) throws SQLException {
		if (xuanZeDao.insertXuanZe(xuanZe) > 0)
			return true;
		return false;
	}

	@Override
	public int getXZScore(List<XZDTK> xzdtks) throws SQLException {

		return xuanZeDao.getXZScore(xzdtks);
	}

	@Override
	public List<XuanZe> findXuanZeByPageNum(int pageNum) throws SQLException {

		return xuanZeDao.findXuanZeByPageNum(pageNum);
	}

	@Override
	public long selectAllCount() throws SQLException {

		long count = xuanZeDao.selectCount();
		return count % Constant.PAGE_SIZE == 0 ? count / Constant.PAGE_SIZE : count / Constant.PAGE_SIZE + 1;
	}

	@Override
	public XuanZe findXuanZeById(int id) throws SQLException {
		
		return xuanZeDao.selectXuanZeById(id);
	}

}
