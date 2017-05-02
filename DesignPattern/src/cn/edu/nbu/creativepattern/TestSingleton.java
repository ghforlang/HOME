package cn.edu.nbu.creativepattern;

public class TestSingleton {
	
	//私有构造方法，防止被实例化
	private TestSingleton(){}
	//内部类维护单例
	private static class SingletonFactory{
		private static TestSingleton instance = new TestSingleton();
	}
	//获取实例
	public static TestSingleton getInstance(){
		return SingletonFactory.instance;
	}
	//若该对象用于序列化，可以保证对象在序列化前后保持一致
	public Object readResolve(){
		return getInstance();
	}
}
