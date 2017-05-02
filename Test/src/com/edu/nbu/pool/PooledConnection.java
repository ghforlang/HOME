package com.edu.nbu.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * �����ӳع������ݿ����ӹܵ�
 */
public class PooledConnection {
	//��װ������ʵ�ܵ� jdk�ṩ�Ĺܵ�(jdbc����)
	private Connection connection;
	//�Ƿ�����ռ��(�������ӳع���)
	private boolean isBusy;
	
	public PooledConnection(Connection connection,boolean isBusy){
		this.connection = connection;
		this.isBusy = isBusy;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return the isBusy
	 */
	public boolean isBusy() {
		return isBusy;
	}

	/**
	 * @param isBusy the isBusy to set
	 */
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
	//�ܵ������ӣ��������ͷŵķ���
	public void release(){
		this.isBusy = false;
	}
	
	//�Զ���ܵ������ӣ�ҵ�񷽷�
	/*
	 * �������£�1����������connection��2������statement��3��ִ��sql��䣬����ResultSet��
	 */
	public ResultSet queryBySql(String sql){
		Statement sm = null;
		ResultSet resultSet = null;
		try {
			sm =  connection.createStatement();
			resultSet = sm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
}
