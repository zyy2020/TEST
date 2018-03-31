package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wenjuan.dao.XuanZeDao;
import com.wenjuan.bean.XZDTK;
import com.wenjuan.bean.XuanZe;
import com.wenjuan.utils.Constant;
import com.wenjuan.utils.JdbcUtil;

public class XuanZeDaoImpl implements XuanZeDao {

	@Override
	public List<XuanZe> selectAllXuanZes() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_xuanze";
		List<XuanZe> listXuanZes = (List<XuanZe>) qr.query(sql, new BeanListHandler(XuanZe.class));
		return listXuanZes;
	}

	@Override
	public int insertXuanZe(XuanZe xuanZe) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "insert into tb_xuanze values(?,?,?,?,?,?,?,?,?,?)";
		Object params[] = { xuanZe.getId(), xuanZe.getTitle(), xuanZe.getKey1(), xuanZe.getWeight1(), xuanZe.getKey2(),
				xuanZe.getWeight2(), xuanZe.getKey3(), xuanZe.getWeight3(), xuanZe.getKey4(), xuanZe.getWeight4() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int updateXuanZe(XuanZe xuanZe) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "update tb_xuanze set title=?,key1=?,weight1=?,key2=?,weight2=?,key3=?,weight3=?,key4=?,weight4=? where id=?";
		Object params[] = { xuanZe.getTitle(), xuanZe.getKey1(), xuanZe.getWeight1(), xuanZe.getKey2(),
				xuanZe.getWeight2(), xuanZe.getKey3(), xuanZe.getWeight3(), xuanZe.getKey4(), xuanZe.getWeight4(),
				xuanZe.getId() };
		int update = qr.update(sql, params);
		return update;
	}

	@Override
	public int deleteXuanZeById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "delete from tb_xuanze where id=?";
		Object param = id;
		int update = qr.update(sql, param);
		int ss=update;
		return update;
	}

	@Override
	public XuanZe selectXuanZeById(int id) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_xuanze where id=?";
		Object param = id;
		XuanZe xuanZe = (XuanZe) qr.query(sql, param, new BeanHandler(XuanZe.class));
		return xuanZe;
	}

	@Override
	public long selectCount() throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select count(id) from tb_xuanze ";
		long count = (Long) qr.query(sql, new ScalarHandler(1));
		return count;
	}

	@Override
	public int getXZScore(List<XZDTK> xzdtks) throws SQLException {
		int score = 0;
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql_f = "select answer from tb_xzdtk where xuanZeId=?";
		String sql_t = "select weight1,weight2,weight3,weight4 from tb_xuanze where id=?";
		Object param;

		Object[] weights;
		for (XZDTK xzdtk : xzdtks) {
			// 锟矫碉拷锟皆撅拷拇锟�
			param = xzdtk.getXuanZeId();
			char answer = xzdtk.getAnswer().charAt(0);
			// 锟矫碉拷锟斤拷锟斤拷目锟斤拷锟斤拷确锟斤拷
			weights = qr.query(sql_t, param, new ArrayHandler());
			// 锟斤拷锟斤拷锟斤拷锟�
			switch (answer) {
			case 'A':
				score += (int) weights[0];
				break;
			case 'B':
				score += (int) weights[1];
				break;
			case 'C':
				score += (int) weights[2];
				break;
			case 'D':
				score += (int) weights[3];
				break;
			default:
				break;
			}
		}
		return score;
	}

	@Override
	public List<XuanZe> findXuanZeByPageNum(int pageNum) throws SQLException {
		QueryRunner qr = JdbcUtil.getQueryRunner();
		String sql = "select * from tb_xuanze limit ?,?";
		//从第几个，输出几个
		Object[] params = { (pageNum - 1) * Constant.PAGE_SIZE, Constant.PAGE_SIZE };
		List<XuanZe> listXuanZes = (List<XuanZe>) qr.query(sql, params, new BeanListHandler(XuanZe.class));

		return listXuanZes;
	}

}
