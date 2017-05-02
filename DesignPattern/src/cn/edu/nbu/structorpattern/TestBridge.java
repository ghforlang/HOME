package cn.edu.nbu.structorpattern;
//具体使用场景：jdbc驱动加载过程中；
public class TestBridge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bridge bridge = new MyBridge();
		
		Sourceable source1 =  new SourSub1();
		bridge.setSource(source1);
		bridge.method();
		
		Sourceable source2 =  new SourSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}

class SourSub1 implements Sourceable{
	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("this is SourSub1");
	}
}

class SourSub2 implements Sourceable{
	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("this is SourSub2");
	}
}

abstract class Bridge{
	private Sourceable source;
	public void method(){
		source.method();
	}
	
	public Sourceable getSource(){
		return source;
	}
	public void setSource(Sourceable source){
		this.source = source;
	}
}

class MyBridge extends Bridge{
	public void method(){
		getSource().method();
	}
}