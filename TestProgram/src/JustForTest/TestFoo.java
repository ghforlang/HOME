package JustForTest;

public class TestFoo {
	public static void main(String[] args) {
		Foo a = new Bar();
		//a.addFive();//����Foo��addFive��������ʱ�����ڶ�̬�����಻����addFive������
		a.addFive();//���������addFive������
		System.out.println(a.a);
	}
}

class Foo{
	public int a;
	public Foo(){
		a = 3;
	}
	public void addFive(){
		a += 5;
	}
}

class Bar extends Foo{
	public int a;
	public Bar(){
		a = 8;
	}
	public void addFive(){
		a += 5;
	}
}