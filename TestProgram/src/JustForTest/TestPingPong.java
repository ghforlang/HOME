package JustForTest;

public class TestPingPong {
	
	public static void main(String[] args) {
		Thread t =  new Thread(){
			public void run(){
				pong();
			}
		};
		t.start();//�̴߳��ھ���״̬����JVM���ø��̵߳�run����
		//t.run();//ֱ�ӵ���run�����൱�ڵ������̵߳ı��ط�����û�ж��߳�Ч����ֻ�е���start���������̲߳���������
		System.out.println("ping");
		System.out.println(Double.NaN);
	}
	
	static void pong(){
		System.out.println("pong");
	}
}