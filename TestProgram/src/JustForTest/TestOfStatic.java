package JustForTest;

public class TestOfStatic {

	public static void main(String[] args) {
		BB.printA();
		BB.printB();
		System.out.println(BB.b);
	}

}

class AA {
	static int a = 1;
	static int b = 2;
	
	public static void printA(){
		System.out.println(a);
	}
	public static void printB(){
		System.out.println(b);
	}
}

class BB extends AA{
	 static int a = 11;
	 static int b = 22;
	
//	public static void printB(){
//		System.out.println(b);
//	}
}