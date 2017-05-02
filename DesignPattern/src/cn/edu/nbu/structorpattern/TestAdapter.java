package cn.edu.nbu.structorpattern;
//���������ģʽ����һ��Source�࣬ӵ��һ�������������䣬
//Ŀ��ӿ�ʱTargetable��ͨ��Adapter�࣬��Source�Ĺ�����չ��Targetable��
public class TestAdapter{
	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method();
		target.method1();
	}
}

class Source1{
	public void method(){
		System.out.println("this is method");
	}
}

class Adapter extends Source1 implements Targetable{

	@Override
	public void method1() {
		System.out.println("this is method1");
	}
}
