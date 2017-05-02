package cn.edu.nbu.structorpattern;

//װ������б�װ����Ķ���
public class TestDecorator {
	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}
}

class Source implements Sourceable{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("Original method");
	}
}

class Decorator implements Sourceable{
	private Sourceable source;
	public  Decorator(Sourceable source){
		super();
		this.source = source;
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("before decoratored");
		source.method();
		System.out.println("after decoratored");
	}
}

