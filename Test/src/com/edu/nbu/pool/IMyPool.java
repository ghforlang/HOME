package com.edu.nbu.pool;

public interface IMyPool {
	public PooledConnection getConnection();
	public void createConnections(int count);
}
