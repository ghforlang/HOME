package JustForTest;


public class TestWait {
	public static void main(String[] args) {
		new Thread(new ClassThread1()).start();
		try {    Thread.sleep(10);  
		} catch (InterruptedException e) {  
			// TODO Auto-generated catch block   
			e.printStackTrace();   }  
		new Thread(new ClassThread2()).start(); 
		}
	}
	
	class ClassThread1 implements Runnable{

		@Override
		public void run() {
			synchronized (TestWait.class) {
				System.out.println("enter ClassThread1");
				System.out.println("ClassThread1 is waiting");
				//释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了 synchronized关键字管辖的代码范围
				//另一种方式就是在synchronized关键字管辖的代码 内部调用监视器对象的wait方法。这里，使用wait方法释放锁。 
				try {
					TestWait.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("ClassThread1 is going on");
				System.out.println("ClassThread1 is being over");
			}
		}
		
	}

	class ClassThread2 implements Runnable{

		@Override
		public void run() {
			synchronized (TestWait.class) {
				System.out.println("enter ClassThread2");
				System.out.println("ClassThread2 notify other thread can release wait status..");
				//由于notify方法并不释放锁， 即使thread2调用下面的sleep方法休息了10毫秒，
				//但 thread1仍然不会执行，因为thread2没有释放锁，所以Thread1无法得不到锁
				TestWait.class.notify();
				System.out.println("ClassThread2 sleep 10 s");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("ClassThread2 is going on");
				System.out.println("ClassThread2 is being over");
			}
		}
		
}
