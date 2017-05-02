package JustForTest;

public class TestTryCatchFinally {

	public static void main(String[] args) {
		System.out.println(new TestTryCatchFinally().get());
	}
	
	@SuppressWarnings("finally")
	public int get(){
		try{
			return fun1();//funִ�У���������������ֵ
		}finally{
			return fun2();//funִ�У����շ���ֵ
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
