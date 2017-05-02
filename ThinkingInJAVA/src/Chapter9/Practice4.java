package Chapter9;

public class Practice4 {

	public static void main(String[] args) {
		B b = new B1();
		B1.getElem(b);
	}

}

abstract class B{};

class B1 extends B{
	void print(){
		System.out.println("this is base1");
	}
	public static void getElem(B b){
		B1 base = (B1)b;
		System.out.println(base.getClass());
	}
}
