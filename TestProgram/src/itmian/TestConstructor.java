package itmian;

public class TestConstructor extends CConstructor{
	public  static void main(String[] args) {
		String s = "TestConstructor";
		TestConstructor tc = new TestConstructor(s);//���ø���Ĭ�Ϲ��췽�����������๹�췽���Ƿ��в�����
		tc.print();
	}
	public TestConstructor(String s){
		super(s);
		System.out.println(s);
	}
}

class CConstructor{
	String a = "ccc";
	public void print(){
		System.out.println("hello");
	}
	public CConstructor(String a){
		System.out.println(a);
	}
	public String toString(){
		return "aaa";
	}
}