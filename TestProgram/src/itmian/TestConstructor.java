package itmian;

public class TestConstructor extends CConstructor{
	public  static void main(String[] args) {
		String s = "TestConstructor";
		TestConstructor tc = new TestConstructor(s);//调用父类默认构造方法（不管子类构造方法是否有参数）
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