package com.wenjuan.service;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.bean.ADTK;
import com.wenjuan.bean.ShiJuan;

public interface ADTKService {
	
	boolean insertADTK(List<ADTK> adtks) throws SQLException;

	
	List<ADTK> selectSJDTK(ShiJuan shiJuan) throws SQLException;
}
