package com.edu.nbu.pool;

/*
 * �ڲ�����ģʽά���̳߳ض����ṩ����
 */
public class PoolManager {
	private static class CreatePool{
		private static MyPool pool = new MyPool();
	}
	
	/*
	 * ���̻߳����£������ڲ����ʱ���̻߳���
	 */
	public static MyPool getInstance(){
		return CreatePool.pool;
	}
}
