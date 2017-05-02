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

	//���ӳ�׼���ͽ��ⲿ���õ�ʱ��������
	private static String jdbcDriver = "";
	private static String jdbcurl = "";
	private static String userName = "";
	private static String password = "";
	
	//-----�淶���ӳعܵ���������
	private static int initCount;
	private static int stepSize;
	private static int maxSize;
	
	//���ùܵ�����ļ��ϣ�������̰߳�ȫ�ģ�
	private static Vector<PooledConnection> poolList = new Vector<PooledConnection>();
	
	public MyPool() {
		//��ʼ������
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
		
		//�����ܵ�
		try {
			//mysql������
			Driver driver = (Driver)Class.forName(jdbcDriver).newInstance();
			
			//ע������
			DriverManager.registerDriver(driver);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ڴ����ܵ�����
		createConnections(initCount);
	}
	
	//�ܵ�����
	@Override
	public PooledConnection getConnection() {
		if(poolList.size() == 0){
			System.out.println("���ӳ��޹ܵ�����");
			throw new RuntimeException("���ӳ��޹ܵ�����");
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
		//�ж�list���Ƿ��п��п��ùܵ�
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

	//�����ܵ��ķ���ʵ�����Ѿ������ṩ
	@Override
	public void createConnections(int count) {
		if(count>0 && maxSize > 0 && poolList.size() + count > maxSize){
			System.out.println("����������������ƣ���������ʧ�ܣ�");
			throw new RuntimeException("����������������ƣ���������ʧ�ܣ�");
		}
		for(int i=0;i<count;i++){
			try {
				Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
				PooledConnection pooledConnection = new PooledConnection(connection, false);
				//����ܵ�����list
				poolList.add(pooledConnection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
