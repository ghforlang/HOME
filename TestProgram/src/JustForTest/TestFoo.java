package JustForTest;

public class TestFoo {
	public static void main(String[] args) {
		Foo a = new Bar();
		//a.addFive();//调用Foo的addFive方法，此时不存在多态（子类不包含addFive方法）
		a.addFive();//调用子类的addFive方法，
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