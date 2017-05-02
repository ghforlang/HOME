package cn.edu.nbu.structorpattern;
//类的适配器模式，有一个Source类，拥有一个方法，待适配，
//目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
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
