package JustForTest;

public class TestPingPong {
	
	public static void main(String[] args) {
		Thread t =  new Thread(){
			public void run(){
				pong();
			}
		};
		t.start();//线程处于就绪状态，后JVM调用该线程的run方法
		//t.run();//直接调用run方法相当于调用主线程的本地方法，没有多线程效果，只有调用start方法，多线程才真正启动
		System.out.println("ping");
		System.out.println(Double.NaN);
	}
	
	static void pong(){
		System.out.println("pong");
	}
}