package JustForTest;
//˰�ѱ�����
public class TestC extends C1 {
	int i = 2;
	public void test2(){
		System.out.print(i);
	}
	public static void main(String[] args) {
		C1 test = new TestC();
		test.test1();//���ʻ����i��ӡ
		test.test2();//���������i��ӡ
		System.out.print(test.i + " ");//��ȡ����iֵ
		test = (TestC)test;
		System.out.print(test.i + " ");//��ȡ����
		
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
