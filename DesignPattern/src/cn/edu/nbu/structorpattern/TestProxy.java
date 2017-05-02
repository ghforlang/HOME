package cn.edu.nbu.structorpattern;

public class TestProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proxy p = new Proxy();
		p.method();
	}
}


class Sour implements Sourceable{
	public void method(){
		System.out.println("the original method");
	}
}

class Proxy implements Sourceable{
	
	private Sour source;
	public Proxy(){
		super();
		this.source = new Sour();
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		source.method();
		after();
	}
	
	private void before(){
		System.out.println("before proxy");
	}
	
	private void after(){
		System.out.println("after proxy");
	}
}