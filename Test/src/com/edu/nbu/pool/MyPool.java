package com.edu.nbu.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class MyPool implements IMyPool{

	//连接池准备惩戒外部配置的时机参数；
	private static String jdbcDriver = "";
	private static String jdbcurl = "";
	private static String userName = "";
	private static String password = "";
	
	//-----规范连接池管道数量参数
	private static int initCount;
	private static int stepSize;
	private static int maxSize;
	
	//内置管道对象的集合（最好是线程安全的）
	private static Vector<PooledConnection> poolList = new Vector<PooledConnection>();
	
	public MyPool() {
		//初始化连接
		init();
	}
	
	private void init(){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbcPool.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("jdbcDriver");
		jdbcurl = properties.getProperty("jdbcurl");
		userName = properties.getProperty("userName");
		password = properties.getProperty("password");
		
		initCount = Integer.valueOf(properties.getProperty("initCount"));
		stepSize = Integer.valueOf(properties.getProperty("stepSize"));
		maxSize = Integer.valueOf(properties.getProperty("maxSize"));
		
		//创建管道
		try {
			//mysql的驱动
			Driver driver = (Driver)Class.forName(jdbcDriver).newInstance();
			
			//注册驱动
			DriverManager.registerDriver(driver);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//对内创建管道连接
		createConnections(initCount);
	}
	
	//管道服务
	@Override
	public PooledConnection getConnection() {
		if(poolList.size() == 0){
			System.out.println("连接池无管道对象");
			throw new RuntimeException("连接池无管道对象！");
		}
		PooledConnection realConnection = getRealConnection();
		while(realConnection == null){
			createConnections(stepSize);
			realConnection = getRealConnection();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realConnection;
	}

	private synchronized PooledConnection getRealConnection() {
		Connection connection = null;
		//判断list里是否有空闲可用管道
		for(PooledConnection conn : poolList){
			if(!conn.isBusy()){
				connection = conn.getConnection();
				try {
					if(connection.isValid(2000)){
						connection = DriverManager.getConnection(jdbcurl, userName, password);
						conn.setConnection(connection);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn.setBusy(true);
				return conn;
			}
		}
		return null;
	}

	//创建管道的方法实际上已经对外提供
	@Override
	public void createConnections(int count) {
		if(count>0 && maxSize > 0 && poolList.size() + count > maxSize){
			System.out.println("连接数超过最大限制，创建连接失败！");
			throw new RuntimeException("连接数超过最大限制，创建连接失败！");
		}
		for(int i=0;i<count;i++){
			try {
				Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
				PooledConnection pooledConnection = new PooledConnection(connection, false);
				//加入管道连接list
				poolList.add(pooledConnection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
