package com.wenjuan.service;

import java.sql.SQLException;

import com.wenjuan.bean.Mgr;

public interface MgrService {
	/**
	 * ����Ա��¼
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	Mgr login(String name, String pwd) throws SQLException;
}
