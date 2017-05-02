package JustForTest;

public class TestTryCatchFinally {

	public static void main(String[] args) {
		System.out.println(new TestTryCatchFinally().get());
	}
	
	@SuppressWarnings("finally")
	public int get(){
		try{
			return fun1();//fun执行，但并不立即返回值
		}finally{
			return fun2();//fun执行，最终返回值
		}
	}
	int fun1(){
		System.out.println("fun1");
		return 1;
	}
	int fun2(){
		System.out.println("fun2");
		return 2;
	}
}
