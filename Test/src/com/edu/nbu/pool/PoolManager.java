package com.edu.nbu.pool;

/*
 * 内部单例模式维护线程池对外提供服务
 */
public class PoolManager {
	private static class CreatePool{
		private static MyPool pool = new MyPool();
	}
	
	/*
	 * 多线程环境下，加载内部类的时候，线程互斥
	 */
	public static MyPool getInstance(){
		return CreatePool.pool;
	}
}
