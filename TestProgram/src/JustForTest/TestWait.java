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
				//�ͷ��������ַ�ʽ����һ�ַ�ʽ�ǳ�����Ȼ�뿪�������ķ�Χ��Ҳ�����뿪�� synchronized�ؼ��ֹ�Ͻ�Ĵ��뷶Χ
				//��һ�ַ�ʽ������synchronized�ؼ��ֹ�Ͻ�Ĵ��� �ڲ����ü����������wait���������ʹ��wait�����ͷ����� 
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
				//����notify���������ͷ����� ��ʹthread2���������sleep������Ϣ��10���룬
				//�� thread1��Ȼ����ִ�У���Ϊthread2û���ͷ���������Thread1�޷��ò�����
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
