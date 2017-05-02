package cn.edu.nbu.structorpattern;
//接口适配器，定义抽象类实现某接口（接口方法被实现），继承该抽象类（实现需要实现的方法）
//并不与原始的接口打交道
public class TestAdapter2 {
	public static void main(String[] args) {
		Sourcable s1 = new SourceSub1();
		Sourcable s2 = new SourceSub2();
		
		s1.method1();
		s2.method2();
		s1.method2();
		s2.method1();
	}
	
}

abstract class Wrapper2 implements Sourcable{
	public void method1(){};
	public void method2(){};
}

class SourceSub1 extends Wrapper2{
	public void method1(){
		System.out.println("this is method1");
	}
}

class SourceSub2 extends Wrapper2{
	public void method2(){
		System.out.println("this is method2");
	}
}