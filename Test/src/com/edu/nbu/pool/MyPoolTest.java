package com.edu.nbu.pool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyPoolTest {
	private static MyPool pool = PoolManager.getInstance();
	
	public static void main(String[] args) {
		//考虑多线程查询情况
		for(int i=0;i<2000;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					selectAll();
				}
			}).start();
		}
//		selectAll();
	}
	
	public synchronized static void selectAll(){
		PooledConnection connection =pool.getConnection();
		ResultSet resultSet = connection.queryBySql("SELECT * FROM courses");
		System.out.println("线程名： "+ Thread.currentThread().getName());
		try {
			while(resultSet.next()){
				System.out.println(resultSet.getString("CoursesID") +"\t\t");
			}
			resultSet.close();
			connection.release();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
