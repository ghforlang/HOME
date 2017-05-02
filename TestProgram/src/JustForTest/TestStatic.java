package JustForTest;

public class TestStatic {
	//对于属性和静态方法来说，调用取决于声明的类型，而对于其他的取决于运行时的类型，这里A是声明类型，B则是运行时的类型。
	//静态的方法是调用申明的类的方法,非静态的方法是调用被引用的类的方法
	public static void main(String[] args) {
		A c = new B();
		c.f1();
		c.f2();
		System.out.println(c.i);//对于属性和静态方法而言，调用取决于声明的类型，因此结果为1
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
