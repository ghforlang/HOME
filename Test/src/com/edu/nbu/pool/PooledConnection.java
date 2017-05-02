package com.edu.nbu.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 被连接池管理数据库连接管道
 */
public class PooledConnection {
	//封装物理真实管道 jdk提供的管道(jdbc连接)
	private Connection connection;
	//是否被任务占用(用于连接池管理)
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
	
	//管道（连接）本身有释放的方法
	public void release(){
		this.isBusy = false;
	}
	
	//自定义管道（连接）业务方法
	/*
	 * 步骤如下：1、创建连接connection；2、创建statement；3、执行sql语句，返回ResultSet；
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
