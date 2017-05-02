package cn.edu.nbu.creativepattern;

public class TestSingleton2 {
	private static TestSingleton2 instance = null;
	
	private TestSingleton2(){}
	//单独为创建方法加synchronized
	private static synchronized void sysInit(){
		if(instance == null){
			instance = new TestSingleton2();
		}
	}
	
	public static TestSingleton2 getInstance(){
		if(instance == null){
			sysInit();	
		}
		return instance;
	}
	
	public Object readSolve(){
		return getInstance();
	}
}
