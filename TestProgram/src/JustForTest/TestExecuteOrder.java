package JustForTest;

//��̬���顢�������飨����ֻ�д����ŵ��ǿ飩�Լ����캯����ִ��˳��
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