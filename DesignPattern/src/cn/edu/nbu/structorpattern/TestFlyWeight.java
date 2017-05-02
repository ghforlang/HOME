package cn.edu.nbu.structorpattern;
//��Ԫģʽ�����ݿ����ӳ�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class TestFlyWeight {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionPool cp =ConnectionPool.getInstance();
	    Connection conn = cp.getConnection();
	}
}

class ConnectionPool{
	
	private Vector<Connection> pool;
	
	//��������
	private String url = "jdbc:mysql://localhost:3306/test";
	private String username = "root";
	private String password = "root";
	private String driverClassName = "com.mysql.jdbc.Driver";
	
	private int poolsize = 100;
	private static ConnectionPool instance;
	Connection conn = null;
	
	//���췽������ʼ������
	private ConnectionPool(){
		pool = new Vector<Connection>(poolsize);
		
		for(int i=0;i<poolsize;i++){
			try {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		
		}
	}
	
	//�������ӵ����ӳ�
	public synchronized void release(){
		pool.add(conn);
	}
	
	public synchronized Connection getConnection(){
		if(pool.size() >0){
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		}else {
			return null;
		}
	}
	
	public static ConnectionPool getInstance(){
		return new ConnectionPool();
	}
}
