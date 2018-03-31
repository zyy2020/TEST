package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.wenjuan.dao.ShiJuanDao;
import com.wenjuan.dao.impl.ShiJuanDaoImpl;
import com.wenjuan.bean.ShiJuan;
import com.wenjuan.service.ShiJuanService;

public class ShiJuanServiceImpl implements ShiJuanService {
    private ShiJuanDao shiJuanDao=new ShiJuanDaoImpl();
	@Override
	public boolean insertShiJuan(ShiJuan shiJuan) throws SQLException {
		if(shiJuanDao.insertShiJuan(shiJuan)>=0)
			return true;
		return false;
	}

	@Override
	public List<ShiJuan> selectAllShiJuans() throws SQLException {
		return shiJuanDao.selectAllShiJuans();
	}

	@Override
	public ShiJuan selectShiJuan(Date riqi, String title) throws SQLException {

		return shiJuanDao.selectShiJuanByRiQiAndName(riqi, title);
	}

	@Override
	public long selectAllPage() throws SQLException {
		long count = shiJuanDao.selectCount();
		
		return count%12==0?count/12:count/12+1;
	}

	@Override
	public List<ShiJuan> selectPageNum(int pageNum) throws SQLException {
		
		return shiJuanDao.selectShiJuanByPageNum(pageNum);
	}

	@Override
	public ShiJuan selectById(int id) throws SQLException {
	
		return shiJuanDao.selectById(id);
	}

	@Override
	public boolean deleteById(int id) throws SQLException {
		int dou = shiJuanDao.deleteShiJuanById(id);
		if(dou>0) {
			return true;
		}
		return false;
	}

}
