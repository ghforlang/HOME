package Chapter9;
//构造器内部多态方法调用
public class Practice3 {
	//将分配给对象的存储空间
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass sc = new SubClass();
		sc.print();
	}
}

abstract class BaseClass{
	public abstract void print();
	public BaseClass(){
		print();//调用子类print方法
		System.out.println("hello");
	}
}

class SubClass extends BaseClass{
	private int i = 90;
	public void print(){
		System.out.println(i);
	}
}

//output 
// 0
// 90