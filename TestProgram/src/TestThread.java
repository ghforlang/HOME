
public class TestThread {
	public int tickets = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SellThread st = new SellThread();
		//three windows sell 10 tickets in common;
		//new Thread(st).run();//wrong,main thread ,do not implements multi-thread actually.
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}
	static class SellThread implements Runnable{

		int t = new TestThread().tickets;
		public void run() {
			// TODO Auto-generated method stub
			while(t > 0){
				System.out.println(Thread.currentThread().getName() + "   " + t + "  sold");
				t --;
			}
		}
		
	}
}
