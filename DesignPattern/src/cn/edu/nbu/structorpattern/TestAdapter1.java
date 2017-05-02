package cn.edu.nbu.structorpattern;
//����������ģʽ�����ж����ʵ��
public class TestAdapter1 {
	public static void main(String[] args) {
		Source1 source = new Source1();
		Targetable target = new Wrapper(source);
		target.method();
		target.method1();
	}
}

class Wrapper implements Targetable{
	private Source1 source;
	
	public Wrapper(Source1 source){
		super();
		this.source = source;
	}

	@Override
	public void method() {
		source.method();
	}

	@Override
	public void method1() {
		System.out.println("this is method1");
	}
}
