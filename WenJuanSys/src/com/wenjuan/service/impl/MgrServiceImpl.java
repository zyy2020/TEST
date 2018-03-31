package com.wenjuan.service.impl;

import java.sql.SQLException;

import com.wenjuan.dao.MgrDao;
import com.wenjuan.dao.impl.MgrDaoImpl;
import com.wenjuan.bean.Mgr;
import com.wenjuan.service.MgrService;

public class MgrServiceImpl implements MgrService {
    private MgrDao mgrDao=new MgrDaoImpl();
	@Override
	public Mgr login(String name, String pwd) throws SQLException {
	
			return mgrDao.selectMgrBynameAndPwd(name, pwd);
	
	}

}
