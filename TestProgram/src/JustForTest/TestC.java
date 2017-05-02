package JustForTest;
//税友笔试题
public class TestC extends C1 {
	int i = 2;
	public void test2(){
		System.out.print(i);
	}
	public static void main(String[] args) {
		C1 test = new TestC();
		test.test1();//访问基类的i打印
		test.test2();//访问自身的i打印
		System.out.print(test.i + " ");//获取基类i值
		test = (TestC)test;
		System.out.print(test.i + " ");//获取基类
		
		TestC t = new TestC();
		t.test1();
		t.test2();
		System.out.print(t.i + " ");
	}
}
class C1{
	int i = 0;
	public void test1(){
		System.out.print(" " + i + " ");
	}
	public void test2(){
		System.out.print(" " + i + " ");
	}
}
