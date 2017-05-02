package JustForTest;

//静态语句块、构造语句块（就是只有大括号的那块）以及构造函数的执行顺序
public class TestExecuteOrder {
	public static void main(String[] args) {
		HelloA ha = new HelloB();
		new HelloB();
		String s;
		//System.out.println("s=" + s);
	}
}

class HelloA{
	public HelloA(){
		System.out.println("helloA");
	}
	{System.out.println("I am helloA");}
	
	static{
		System.out.println("static helloA");
	}
}

class HelloB extends HelloA{
	public HelloB(){
		System.out.println("helloB");
	}
	{System.out.println("I am helloB");}
	
	static{
		System.out.println("static helloB");
	}
}