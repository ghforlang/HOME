package JustForTest;

public class TestStatic {
	//�������Ժ;�̬������˵������ȡ�������������ͣ�������������ȡ��������ʱ�����ͣ�����A���������ͣ�B��������ʱ�����͡�
	//��̬�ķ����ǵ�����������ķ���,�Ǿ�̬�ķ����ǵ��ñ����õ���ķ���
	public static void main(String[] args) {
		A c = new B();
		c.f1();
		c.f2();
		System.out.println(c.i);//�������Ժ;�̬�������ԣ�����ȡ�������������ͣ���˽��Ϊ1
	}

}

class A{
	int i = 1;
	public static void f1(){
		System.out.println("fa");
	}
	
	public void f2(){
		System.out.println("faa");
	}
}

class B extends A{
	int i = 11;
	public static void f1(){
		System.out.println("fb");
	}
	
	public void f2(){
		System.out.println("fbb");
	}
}
