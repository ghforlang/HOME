package cn.edu.nbu.creativepattern;

public class Singleton {
	//持有私有静态实例，防止被引用，赋值为null,实现延迟加载
	private static Singleton instance = null;
	
	//私有构造方法，防止被实例化
	private Singleton(){}
	
	//静态方法，创建实例
	//多线程环境下会出现问题；instace = new Singleton()分两步执行，具体参见package-info
	//采用加锁机制
	public synchronized static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	//减小加锁粒度
	public static Singleton getInstance1(){
		synchronized (instance) {
			if(instance == null)
				instance = new Singleton();
		}
		return instance;
	}
	
	//处理序列化问题
	public Object readResolve(){
		return instance;
	}
}
