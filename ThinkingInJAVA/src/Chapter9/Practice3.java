package Chapter9;
//�������ڲ���̬��������
public class Practice3 {
	//�����������Ĵ洢�ռ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass sc = new SubClass();
		sc.print();
	}
}

abstract class BaseClass{
	public abstract void print();
	public BaseClass(){
		print();//��������print����
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