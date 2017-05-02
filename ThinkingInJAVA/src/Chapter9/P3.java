package Chapter9;
/**
 * Base1调用过程
 * 首先将分配给对象的存储空间初始化为二进制0；
 * 调用基类的constructor；
 * 按照声明顺序调用成员的初始化方法；
 * 调用子类的constructor主体；
 * @author lenovo
 *
 */
public class P3 {

	public static void main(String[] args) {
		Base1 b = new Base1();//lenovo
		b.print();
	}

}
abstract class Base{
	Base(){
		print();//调用子类的print方法
	}
	abstract void print();
}

class Base1 extends Base{
	private int i = 9;
	public void print(){
		System.out.println("base1---" + this.i);
	}
}

/**
 * output:
 * base1---0
 * base1---9
 */