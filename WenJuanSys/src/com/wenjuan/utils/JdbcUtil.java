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
		// ��ʼ������
		// �Զ�����srcĿ¼��c3p0�������ļ���c3p0-config.xml��
		dataSource = new ComboPooledDataSource();// ʹ��Ĭ�ϵ�����
		// ʹ��c3p0-config.xml�����ļ���named-config��name����ΪC3P0TestName������
		// dataSource = new ComboPooledDataSource("C3P0TestName");
	}

	// ��ȡQueryRunner����
	public static QueryRunner getQueryRunner() { // CRUD
		return new QueryRunner(dataSource);
	}

	// ��ȡ���Ӵ� ͨ��c3p0����������ȡ(������û�õ��÷���)
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
