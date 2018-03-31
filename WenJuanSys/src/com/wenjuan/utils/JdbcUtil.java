package com.wenjuan.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

public class JdbcUtil {
	private static ComboPooledDataSource dataSource = null;
	static {
		// 初始化操作
		// 自动加载src目录下c3p0的配置文件【c3p0-config.xml】
		dataSource = new ComboPooledDataSource();// 使用默认的配置
		// 使用c3p0-config.xml配置文件中named-config的name属性为C3P0TestName的配置
		// dataSource = new ComboPooledDataSource("C3P0TestName");
	}

	// 获取QueryRunner对象
	public static QueryRunner getQueryRunner() { // CRUD
		return new QueryRunner(dataSource);
	}

	// 获取连接纯 通过c3p0核心类对象获取(此例子没用到该方法)
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void releaseDB(Statement stmt, Connection conn) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void releaseDB(ResultSet rs, Statement stmt,
	            Connection conn) {

		 try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		
	}
	 public static void releaseDB(Connection conn) {
		 try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	}
